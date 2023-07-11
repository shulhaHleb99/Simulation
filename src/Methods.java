import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Methods {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static void collectSizeInfo() throws IOException {

        while (true) {
            try {
                System.out.println(Constants.Strings.ENTER_X);
                int x = Integer.parseInt(reader.readLine());
                if (x < 0) {
                    System.out.println(Constants.Strings.MUST_BE_POSITIVE);
                } else if (x > 300) {
                    System.out.println(Constants.Strings.TOO_BIG);
                } else {
                    Main.Params.setTerrainSizeX(x);
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println(Constants.Strings.WRONG_VALUE);
            }
        }

        while (true) {
            try {
                System.out.println(Constants.Strings.ENTER_Y);
                int y = Integer.parseInt(reader.readLine());
                if (y < 0) {
                    System.out.println(Constants.Strings.MUST_BE_POSITIVE);
                } else if (y > 300) {
                    System.out.println(Constants.Strings.TOO_BIG);
                } else {
                    Main.Params.setTerrainSizeY(y);
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println(Constants.Strings.WRONG_VALUE);
            }
        }
    }

    static boolean chooseYesNo(Constants.Strings question) throws IOException {
        System.out.println(question.toString());
        System.out.println("Enter Y or N");
        while (true) {
            String s = reader.readLine();
            if (s.toUpperCase().equals("Y")) {
                return true;
            } else if (s.toUpperCase().equals("N")) {
                return false;
            } else {
                System.out.println(Constants.Strings.WRONG_VALUE);
            }
        }
    }

    private static int getDefaultCreatureCount(int defaultCountIndex) {
        return (int) Math.round(defaultCountIndex * 1.0 / 625 * Main.Params.getSquare());
    }

    static void setDefaultCreatureCount() {
        /*---------------------------------------
         *         Default animal numbers
         ---------------------------------------*/

        final int defaultWolfCountIndex = 50;
        final int defaultSnakeCountIndex = 30;
        final int defaultFoxCountIndex = 40;
        final int defaultBearCountIndex = 15;
        final int defaultEagleCountIndex = 20;
        final int defaultHorseCountIndex = 30;
        final int defaultDeerCountIndex = 75;
        final int defaultRabbitCountIndex = 75;
        final int defaultMouseCountIndex = 80;
        final int defaultGoatCountIndex = 30;
        final int defaultSheepCountIndex = 25;
        final int defaultBoarCountIndex = 50;
        final int defaultBuffaloCountIndex = 25;
        final int defaultDuckCountIndex = 50;
        final int defaultLarvaCountIndex = 150;
        final int defaultPlantCountIndex = 500;

        //------------------------------------------

        var c = Main.Params.creaturesCount;
        c.put("Wolf", defaultWolfCountIndex);
        c.put("Snake", defaultSnakeCountIndex);
        c.put("Fox", defaultFoxCountIndex);
        c.put("Bear", defaultBearCountIndex);
        c.put("Eagle", defaultEagleCountIndex);
        c.put("Horse", defaultHorseCountIndex);
        c.put("Deer", defaultDeerCountIndex);
        c.put("Rabbit", defaultRabbitCountIndex);
        c.put("Mouse", defaultMouseCountIndex);
        c.put("Goat", defaultGoatCountIndex);
        c.put("Sheep", defaultSheepCountIndex);
        c.put("Boar", defaultBoarCountIndex);
        c.put("Buffalo", defaultBuffaloCountIndex);
        c.put("Duck", defaultDuckCountIndex);
        c.put("Larva", defaultLarvaCountIndex);
        c.put("Plant", defaultPlantCountIndex);

    }

    static void setCreaturesCounts() throws IOException {
        int counter = 1;

        for (String name : Constants.creaturesNames) {

            while (true) {
                try {
                    System.out.println(counter + ". Please, enter " + name + "s count:");
                    int inputValue = Integer.parseInt(reader.readLine());
                    if (inputValue > 1000) {
                        System.out.println(Constants.Strings.TOO_BIG);
                    } else if (inputValue < 0) {
                        System.out.println(Constants.Strings.MUST_BE_POSITIVE);
                    } else {
                        Main.Params.creaturesCount.put(name, inputValue);
                        counter++;
                        break;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println(Constants.Strings.WRONG_VALUE);
                }
            }
        }
    }

    static void countDown(int from, String phrase) {
        if (from < 0 || from > 60) {
            return;
        }
        System.out.println(phrase);
        while (from > 0) {
            System.out.println(from--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                //This case should never happen
            }
        }
    }

    static ArrayList<Runnable> prepareThreads() {
        return new ArrayList<Runnable>() {{
            add(new SpeciesHandlerThread())
        }};
    }

}
