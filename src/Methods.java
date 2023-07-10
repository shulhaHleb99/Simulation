import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
            if (s.equals("Y")) {
                return true;
            } else if (s.equals("N")) {
                return false;
            } else {
                System.out.println(Constants.Strings.WRONG_VALUE);
            }
        }
    }

    private static int getDefaultCreatureCount(int defaultCountIndex) {
        return (int)Math.round(defaultCountIndex * 1.0 / 625 * Main.Params.getSquare());
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

        Main.Params.setWolfCount(Methods.getDefaultCreatureCount(defaultWolfCountIndex));
        Main.Params.setSnakeCount(Methods.getDefaultCreatureCount(defaultSnakeCountIndex));
        Main.Params.setFoxCount(Methods.getDefaultCreatureCount(defaultFoxCountIndex));
        Main.Params.setBearCount(Methods.getDefaultCreatureCount(defaultBearCountIndex));
        Main.Params.setEagleCount(Methods.getDefaultCreatureCount(defaultEagleCountIndex));
        Main.Params.setHorseCount(Methods.getDefaultCreatureCount(defaultHorseCountIndex));
        Main.Params.setDeerCount(Methods.getDefaultCreatureCount(defaultDeerCountIndex));
        Main.Params.setRabbitCount(Methods.getDefaultCreatureCount(defaultRabbitCountIndex));
        Main.Params.setMouseCount(Methods.getDefaultCreatureCount(defaultMouseCountIndex));
        Main.Params.setGoatCount(Methods.getDefaultCreatureCount(defaultGoatCountIndex));
        Main.Params.setSheepCount(Methods.getDefaultCreatureCount(defaultSheepCountIndex));
        Main.Params.setBoarCount(Methods.getDefaultCreatureCount(defaultBoarCountIndex));
        Main.Params.setBuffaloCount(Methods.getDefaultCreatureCount(defaultBuffaloCountIndex));
        Main.Params.setDuckCount(Methods.getDefaultCreatureCount(defaultDuckCountIndex));
        Main.Params.setLarvaCount(Methods.getDefaultCreatureCount(defaultLarvaCountIndex));
        Main.Params.setPlantCount(Methods.getDefaultCreatureCount(defaultPlantCountIndex));
    }

    static void setCreaturesCounts() throws IOException {
        int counter = 1;
        String[] creaturesNames = {"Wolf", "Snake", "Fox", "Bear", "Eagle", "Horse", "Deer", "Rabbit", "Mouse", "Goat",
                                    "Sheep", "Boar", "Buffalo", "Duck", "Larva", "Plant"};
        try {
            for (String name : creaturesNames) {
                Method m = Main.Params.class.getDeclaredMethod("set" + name + "Count", int.class);

                while (true) {
                    try {
                        System.out.println(counter + ". Please, enter " + name + "s count:");
                        int inputValue = Integer.parseInt(reader.readLine());
                        if (inputValue > 1000) {
                            System.out.println(Constants.Strings.TOO_BIG);
                        } else if (inputValue < 0) {
                            System.out.println(Constants.Strings.MUST_BE_POSITIVE);
                        } else {
                            m.invoke(Main.Params.class, inputValue);
                            counter++;
                            break;
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println(Constants.Strings.WRONG_VALUE);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        // This case should never happen
                    }
                }
            }
        } catch (NoSuchMethodException nsme) {
            // This case sould never happen
        }

    }


}
