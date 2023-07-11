import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SpeciesHandlerThread implements Runnable {

    private final String speciesName;
    private final int speciesCount;

    private final ArrayList<Creature> speciesContainer;

    public SpeciesHandlerThread(String speciesName, int speciesCount) {
        this.speciesName = speciesName;
        this.speciesCount = speciesCount;
        speciesContainer = createCertainSpeciesInstances();
    }
    private ArrayList<Creature> createCertainSpeciesInstances() {
        ThreadLocalRandom thlRandom = ThreadLocalRandom.current();

        Class<?> c = null;
        ArrayList<Creature> creatures = new ArrayList<>();
        try {
            c = Class.forName(Constants.whoIsWho.get(speciesName) + "_" + speciesName);
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }

        for (int i = 0; i < speciesCount; i++) {
            try {
                creatures.add((Creature) c.getConstructors()[0].newInstance(

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

    }
}
