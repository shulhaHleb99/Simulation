import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

public abstract class Animal implements Creature {


    Cell coords;
    final int id;

    public Animal(int y, int x) {
        coords = Main.Params.terr.getCellArray()[y][x];
        this.id = Main.Params.creaturesNumber.incrementAndGet();
    }

    public Responce move(int cellsPerStep) {
        int fromY = coords.getY();
        int fromX = coords.getX();

        Main.Params.terr.getCellArray()[fromY][fromX].removeCreature(this);

        int oldY = coords.getY();
        int newY = 0;
        int oldX = coords.getX();
        int newX = 0;

        Cell newCoords = null;
        for (int i = 0; i < cellsPerStep; i++) {
            while (true) {
                try {
                    Constants.Directions dir = Methods.getRandomDirection();
                    newY = oldY + dir.deltaY;
                    newX = oldX + dir.deltaX;
                    newCoords = Main.Params.terr.getCellArray()[newY][newX];

                    oldY = newCoords.getY();
                    oldX = newCoords.getX();
                    break;
                } catch (IndexOutOfBoundsException ioobe) {
                    // New cycle iteration
                }
            }
        }

        newCoords.addCreature(this);
        coords = newCoords;
        return new Responce(fromY, fromX);
    }

    public Responce eat(double weight, double kilosForSatiety, HashMap<Class<?>, Integer> whom) {

        int attempts = 2;

        ArrayList<Class<? extends Creature>> ediebleTypes;
        Class<? extends Creature> victimType;

        Responce result = null;

        for (int i = 0; i <= attempts; i++) {

            ediebleTypes = new ArrayList<>();
            for (Creature c : coords.getCreatures()) {
                if (!ediebleTypes.contains(c.getClass())) {
                    ediebleTypes.add(c.getClass());
                }
            }

            ediebleTypes.removeIf(c -> whom.get(c) == null);

            if (ediebleTypes.isEmpty()) {
                return new Responce(2);
            }

            victimType = ediebleTypes.get(ThreadLocalRandom.current().nextInt(0, ediebleTypes.size()));

            synchronized (victimType) {
                List<Creature> potentialVictims = coords.getCreatures()
                        .stream()
                        .filter(victimType::isInstance)
                        .toList();
                Creature victim = potentialVictims.get(ThreadLocalRandom.current().nextInt(0, potentialVictims.size()));

                if (Methods.headsOrTails(Constants.Chances.getChance(this.getClass(), victimType))) {

                    synchronized (SpeciesHandlerThread.class) {
                        Main.Params.allCreatures.get(victimType).remove(victim);
                    }

                    coords.removeCreature(victim);
                    return new Responce(true, victimType, victim.getId(), victim.getCoords().getY(), victim.getCoords().getX());
                } else if (i == attempts) {
                    result = new Responce(false, victimType, victim.getId(), victim.getCoords().getY(), victim.getCoords().getX());
                }
            }
        }
        return result;
    }

    @Override
    public Responce reproduce() {
        int thisTypeCount = 0;

        for (Creature c : getCoords().getCreatures()) {
            if (getClass().isInstance(c)) thisTypeCount++;
        }

        if (thisTypeCount >= 2) {
            Creature c = null;
            try {
                c = (Creature) getClass().getDeclaredConstructors()[0].newInstance(coords.getY(), coords.getX());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                // This case should never happen
            }
            coords.addCreature(c);

            synchronized (SpeciesHandlerThread.class) {
                Main.Params.allCreatures.get(getClass()).add(c);
            }

            String name = getClass().getSimpleName().substring(getClass().getSimpleName().indexOf('_') + 1);
            Main.Params.creaturesCount.put(name, Main.Params.creaturesCount.get(name) + 1);

            return new Responce(true, null, 0, 0, 0);
        } else {
            return new Responce(4);
        }
    }

    protected static HashMap<Class<?>, Integer> whomInit(Class<?> cl) {

        HashMap<Class<?>, Integer> result = new HashMap<>();

        for (Map.Entry<Class<?>, Integer> pair : Constants.Chances.getChance(cl).entrySet()) {
            if (pair.getValue() != 0) {
                result.put(pair.getKey(), pair.getValue());
            }
        }
        return result;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Cell getCoords() {
        return coords;
    }
}
