import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static void main(String[] args) throws IOException {
        if (!Methods.chooseYesNo(Constants.Strings.DEF_SQUARE)) {
            Methods.collectSizeInfo();
        }

        Params.terr = Terrain.getTerr();

        if (!Methods.chooseYesNo(Constants.Strings.DEF_QUANTTIES)) {
            Methods.setCreaturesCounts();
        }

        if (!Methods.chooseYesNo(Constants.Strings.DEF_STEPS)) {
            Params.stepCount = Methods.enterNumber(Constants.Strings.ENTER_STEPS.toString(), 0, 300);
        }

        ExecutorService exec = Executors.newFixedThreadPool(20);
        Params.threads = Methods.prepareThreads();

        Methods.countDown(5, Constants.Strings.START.toString());

        Params.threads.forEach(exec::execute);




    }

    static class Params {

        static Terrain terr;
        private static int terrainSizeX = 25;
        private static int terrainSizeY = 25;

        static AtomicInteger creaturesNumber = new AtomicInteger(0);

        static void setTerrainSizeX(int terrainSizeX) {
            Params.terrainSizeX = terrainSizeX;
        }

        static void setTerrainSizeY(int terrainSizeY) {
            Params.terrainSizeY = terrainSizeY;
        }

        public static int getTerrainSizeX() {
            return terrainSizeX;
        }

        public static int getTerrainSizeY() {
            return terrainSizeY;
        }

        static final ConcurrentHashMap<String, Integer> creaturesCount = new ConcurrentHashMap<>()

        {{
            put("Wolf", Methods.getDefaultCreatureCount(50));
            put("Snake", Methods.getDefaultCreatureCount(30));
            put("Fox", Methods.getDefaultCreatureCount(40));
            put("Bear", Methods.getDefaultCreatureCount(15));
            put("Eagle", Methods.getDefaultCreatureCount(20));
            put("Horse", Methods.getDefaultCreatureCount(30));
            put("Deer", Methods.getDefaultCreatureCount(75));
            put("Rabbit", Methods.getDefaultCreatureCount(75));
            put("Mouse", Methods.getDefaultCreatureCount(80));
            put("Goat", Methods.getDefaultCreatureCount(30));
            put("Sheep", Methods.getDefaultCreatureCount(25));
            put("Boar", Methods.getDefaultCreatureCount(50));
            put("Buffalo", Methods.getDefaultCreatureCount(25));
            put("Duck", Methods.getDefaultCreatureCount(50));
            put("Larva", Methods.getDefaultCreatureCount(150));
            put("Plant", Methods.getDefaultCreatureCount(500));

        }};

        static ArrayList<Runnable> threads;

        //----------------------------------------------

        private static int stepCount = 200;

        public synchronized static int getStepCount() {
            return stepCount;
        }
        private static int currentStep = 1;

        public synchronized static int getCurrentStep() {
            return currentStep;
        }

        static void nextStep() {
            currentStep++;
        }
    }
}