import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class _Plant implements Creature {

    static double weight = 1;
    final Cell coords;
    final int id;


    public _Plant(int y, int x) {
        coords = Main.Params.terr.getCellArray()[y][x];
        this.id = Main.Params.creaturesNumber.incrementAndGet();
    }

    @Override
    public Responce eat() {
        weight *= 1.1;
        return new Responce(3);
    }
    @Override
    public Responce reproduce() {
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(3); i++) {
            _Plant c = null;
            c = new _Plant(coords.getY(), coords.getX());

            coords.addCreature(c);
            Main.Params.allCreatures.get(getClass()).add(c);

            String name = "Plant";
            Main.Params.creaturesCount.put(name, Main.Params.creaturesCount.get(name) + 1);
        }

        return new Responce(5);
    }
    public Responce move() {
        // This method should never happen
        return new Responce(0);
    }


    public int getId() {
        return id;
    }
    public Cell getCoords() {
        return coords;
    }
}
