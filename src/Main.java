import java.io.IOException;
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

        if (Methods.chooseYesNo(Constants.Strings.DEFAULT_QUANTTIES)) {
            Methods.setDefaultCreatureCount();
        } else {
            Methods.setCreaturesCounts();
        }

        ExecutorService exec = Executors.newFixedThreadPool(20);

        Methods.countDown(5, Constants.Strings.START.toString());




    }

    static class Params {

        static Terrain terr;
        private static int terrainSizeX = 25;
        private static int terrainSizeY = 25;

        static AtomicInteger creaturesNumber = new AtomicInteger(0);

        private static final int square = terrainSizeX*terrainSizeY;

        public static int getSquare() {
            return square;
        }

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

        /*---------------------------------------
         *         Actual animal number
         ---------------------------------------*/

        static final ConcurrentHashMap<String, Integer> creaturesCount = new ConcurrentHashMap<>();




    }
}