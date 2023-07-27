import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class SpeciesHandlerThread implements Runnable {

    private final String speciesName;
    private final int beginingSpeciesCount;

    private final ArrayList<? extends Creature> speciesContainer;

    private Class<?> cl;

    private static final CyclicBarrier cBarrier = new CyclicBarrier(16, () -> {
        System.out.println("\n\n");
        Methods.showCommonInfo();

        Main.Params.nextStep();
        System.out.println("\n\n### STEP №" + Main.Params.getCurrentStep() + " ###\n\n");
    });

    public SpeciesHandlerThread(String speciesName) {
        this.speciesName = speciesName;
        try {
            cl = Class.forName(Constants.whoIsWho.get(speciesName) + "_" + speciesName);
        } catch (ClassNotFoundException cnfe) {
            //System.out.println(cnfe.getMessage());
        }
        this.beginingSpeciesCount = Main.Params.creaturesCount.get(speciesName);
        speciesContainer = createCertainSpeciesInstances();
    }

    private ArrayList<Creature> createCertainSpeciesInstances() {

        ArrayList<Creature> creatures = new ArrayList<>();

        for (int i = 0; i < beginingSpeciesCount; i++) {
            try {
                int y = ThreadLocalRandom.current().nextInt(0, Main.Params.getTerrainSizeY());
                int x = ThreadLocalRandom.current().nextInt(0, Main.Params.getTerrainSizeX());
                Creature c = (Creature) cl.getDeclaredConstructors()[0].newInstance(y, x);
                creatures.add(c);

                Main.Params.terr.getCellArray()[y][x].addCreature(c);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Main.Params.allCreatures.put(cl, creatures);

        return creatures;
    }

    public void run() {
        int bound = 3;
        if (speciesName.equals("Plant")) {
            bound = 2;
        }

        while (Main.Params.getCurrentStep() <= Main.Params.getStepCount()) {

            for (Creature c : getSpeciesContainer()) {

                synchronized (cl) {

                    Responce resp;
                    int actionId = switch (ThreadLocalRandom.current().nextInt(0, bound)) {
                        case 0 -> {
                            resp = c.eat();
                            yield 0;
                        }
                        case 1 -> {
                            resp = c.reproduce();
                            yield 1;
                        }
                        case 2 -> {
                            resp = c.move();
                            yield 2;
                        }
                        default -> throw new RuntimeException("Wrong value!");
                    };

                    Methods.makeRecord(c.getId(), c.getCoords().getX(), c.getCoords().getY(), actionId, cl, resp);
                }
                Thread.yield();
            }
            try {
                cBarrier.await();
            } catch (InterruptedException | BrokenBarrierException exception) {
                // This case should never happen
            }
        }
    }

    public ArrayList<? extends Creature> getSpeciesContainer() {
        synchronized (SpeciesHandlerThread.class) {
            return speciesContainer;
        }
    }
}
