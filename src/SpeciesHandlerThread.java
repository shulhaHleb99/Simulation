import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class SpeciesHandlerThread implements Runnable {

    private final String speciesName;
    private final int speciesCount;

    private final ArrayList<? extends Creature> speciesContainer;

    private Class<?> cl;

    private final ThreadLocalRandom thlRandom = ThreadLocalRandom.current();

    private static final CyclicBarrier cBarrier = new CyclicBarrier(15, new Runnable() {
        @Override
        public void run() {
            Main.Params.nextStep();
            System.out.println("\n\n### STEP №" + Main.Params.getCurrentStep() +" ###\n\n");
        }
    });
    public SpeciesHandlerThread(String speciesName) {
        this.speciesName = speciesName;
        this.speciesCount = Main.Params.creaturesCount.get(speciesName);
        speciesContainer = createCertainSpeciesInstances();
    }
    private ArrayList<Creature> createCertainSpeciesInstances() {

        ArrayList<Creature> creatures = new ArrayList<>();
        try {
            cl = Class.forName(Constants.whoIsWho.get(speciesName) + "_" + speciesName);
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }

        for (int i = 0; i < speciesCount; i++) {
            try {
                creatures.add((Creature) cl.getConstructors()[0].newInstance(

                        ThreadLocalRandom.current().nextInt(1, Main.Params.getTerrainSizeX()),
                        ThreadLocalRandom.current().nextInt(1, Main.Params.getTerrainSizeY())

                ));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return creatures;
    }

    public void run() {
        while (Main.Params.getCurrentStep() <= Main.Params.getStepCount()) {
            for (Creature c: speciesContainer) {

                Responce resp;
                int actionId = switch (ThreadLocalRandom.current().nextInt(0, 3)) {
                    case 0 -> {
                        resp = c.eat();
                        yield 0;
                    } case 1 -> {
                        resp = c.reproduce();
                        yield 1;
                    } case 2 -> {
                        resp = c.move();
                        yield 2;
                    }
                    default -> throw new RuntimeException("Wrong value!");
                };

                Methods.makeRecord(c.getId(), c.getCoords().getX(), c.getCoords().getY(), actionId, cl, resp);
            }
            try {
                cBarrier.await();
            } catch (InterruptedException | BrokenBarrierException exception) {
                // This case should never happen
            }
        }
    }
}
