import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Methods {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static void collectSizeInfo() throws IOException {
        Main.Params.setTerrainSizeX(enterNumber(Constants.Strings.ENTER_X.toString(),  0, 300));
        Main.Params.setTerrainSizeY(enterNumber(Constants.Strings.ENTER_Y.toString(), 0, 300));
    }

    static int enterNumber(String question, int from, int to) throws IOException {
        while (true) {
            try {
                System.out.println(question);
                int x = Integer.parseInt(reader.readLine());
                if (x < 0) {
                    System.out.println(Constants.Strings.MUST_BE_POSITIVE);
                } else if (x >= 0 && x < from) {
                    System.out.println(Constants.Strings.CANT_BE_LESS.toString() + from);
                } else if (x > to) {
                    System.out.println(Constants.Strings.TOO_BIG);
                } else {
                    return x;
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

    static int getDefaultCreatureCount(int defaultCountIndex) {
        return (int) Math.round(defaultCountIndex * 1.0 / 625 * Main.Params.getSquare());
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
            for (String name: Constants.creaturesNames) {
                add(new SpeciesHandlerThread(name));
            }
        }};
    }

    static Constants.Directions getRandomDirection() {
        return switch (ThreadLocalRandom.current().nextInt(0, 4)) {
            case 1 -> Constants.Directions.UP;
            case 2 -> Constants.Directions.RIGHT;
            case 3 -> Constants.Directions.DOWN;
            case 0 -> Constants.Directions.LEFT;
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    static void makeRecord(int id, int actionId, boolean result, Class<? extends Creature>... who) {

    }

}
