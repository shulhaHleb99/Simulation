import java.io.IOException;
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
        private static volatile int wolfCount;
        private static volatile int snakeCount;
        private static volatile int foxCount;
        private static volatile int bearCount;
        private static volatile int eagleCount;
        private static volatile int horseCount;
        private static volatile int deerCount;
        private static volatile int rabbitCount;
        private static volatile int mouseCount;
        private static volatile int goatCount;
        private static volatile int sheepCount;
        private static volatile int boarCount;
        private static volatile int buffaloCount;
        private static volatile int duckCount;
        private static volatile int larvaCount;
        private static volatile int plantCount;

        public static int getWolfCount() {
            return wolfCount;
        }

        static void setWolfCount(int wolfCount) {
            Params.wolfCount = wolfCount;
        }

        public static int getSnakeCount() {
            return snakeCount;
        }

        static void setSnakeCount(int snakeCount) {
            Params.snakeCount = snakeCount;
        }

        public static int getFoxCount() {
            return foxCount;
        }

        static void setFoxCount(int foxCount) {
            Params.foxCount = foxCount;
        }

        public static int getBearCount() {
            return bearCount;
        }

        static void setBearCount(int bearCount) {
            Params.bearCount = bearCount;
        }

        public static int getEagleCount() {
            return eagleCount;
        }

        static void setEagleCount(int eagleCount) {
            Params.eagleCount = eagleCount;
        }

        public static int getHorseCount() {
            return horseCount;
        }

        static void setHorseCount(int horseCount) {
            Params.horseCount = horseCount;
        }

        public static int getDeerCount() {
            return deerCount;
        }

        static void setDeerCount(int deerCount) {
            Params.deerCount = deerCount;
        }

        public static int getRabbitCount() {
            return rabbitCount;
        }

        static void setRabbitCount(int rabbitCount) {
            Params.rabbitCount = rabbitCount;
        }

        public static int getMouseCount() {
            return mouseCount;
        }

        static void setMouseCount(int mouseCount) {
            Params.mouseCount = mouseCount;
        }

        public static int getGoatCount() {
            return goatCount;
        }

        static void setGoatCount(int goatCount) {
            Params.goatCount = goatCount;
        }

        public static int getSheepCount() {
            return sheepCount;
        }

        static void setSheepCount(int sheepCount) {
            Params.sheepCount = sheepCount;
        }

        public static int getBoarCount() {
            return boarCount;
        }

        static void setBoarCount(int boarCount) {
            Params.boarCount = boarCount;
        }

        public static int getBuffaloCount() {
            return buffaloCount;
        }

        static void setBuffaloCount(int buffaloCount) {
            Params.buffaloCount = buffaloCount;
        }

        public static int getDuckCount() {
            return duckCount;
        }

        static void setDuckCount(int duckCount) {
            Params.duckCount = duckCount;
        }

        public static int getLarvaCount() {
            return larvaCount;
        }

        static void setLarvaCount(int larvaCount) {
            Params.larvaCount = larvaCount;
        }

        public static int getPlantCount() {
            return plantCount;
        }

        static void setPlantCount(int plantCount) {
            Params.plantCount = plantCount;
        }




    }
}