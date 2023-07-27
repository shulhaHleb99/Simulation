import java.util.HashMap;

public final class Constants {

    static final HashMap<String, String> whoIsWho = new HashMap<>() {{

        put("Bear", "Carnivore");
        put("Eagle", "Carnivore");
        put("Fox", "Carnivore");
        put("Snake", "Carnivore");
        put("Wolf", "Carnivore");

        put("Boar", "Herbivore");
        put("Buffalo", "Herbivore");
        put("Deer", "Herbivore");
        put("Duck", "Herbivore");
        put("Goat", "Herbivore");
        put("Horse", "Herbivore");
        put("Larva", "Herbivore");
        put("Mouse", "Herbivore");
        put("Rabbit", "Herbivore");
        put("Sheep", "Herbivore");

        put("Plant", "");
    }};

    static final String[] creaturesNames = {"Wolf", "Snake", "Fox", "Bear", "Eagle", "Horse", "Deer", "Rabbit", "Mouse", "Goat",
            "Sheep", "Boar", "Buffalo", "Duck", "Larva", "Plant"};

    public enum Strings {
        ENTER_X("Please, enter field param X:"),
        ENTER_Y("Please, enter field param Y:"),
        TOO_BIG("Value is too big"),
        MUST_BE_POSITIVE("Value must be positive"),

        CANT_BE_LESS("Value can't be less than "),
        WRONG_VALUE("Wrong value entered!"),
        DEF_SQUARE("Do you want to use default terrain square 10 x 10?"),
        DEF_QUANTTIES("Use recommended quantities of creatures for this square?"),
        START("Simulation will start in:"),
        DEF_STEPS("Do you want to use default value of steps?"),
        ENTER_STEPS("Please, enter steps number:"),
        IF_EAT_PATT("%s(ID: %d) trying to eat %s(ID: %d). (Chance %d)  Y:%d X:%d Successfully: %s \n"),
        IF_REPRODUCE_PATT("%s(ID: %d) trying to reproduce. Y:%d X:%d Successfully: %s \n"),
        IF_MOVE_PATT("%s(ID: %d) moving from Y:%d X:%d to Y:%d X:%d \n"),
        LARVA_MOVE("Larva(ID: %d) is crawling around the forest. Y:%d X:%d \n"),
        HUNT_FAILED("%s(ID: %d) couldn't have a meal. Y:%d X:%d Successfully: false \n"),
        PLANT_GROWING("Plant(ID: %d) is growing. Y:%d X:%d \n"),
        REPRODUCING_FAILED("%s (ID: %d) couldn't find a pair for reproducing. Y:%d X:%d \n"),
        REPRODUCING_SUCCESSED("%s (ID: %d) successfully reproduced! Y:%d X:%d \n");
        ;

        private String string;

        Strings(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    public enum Colours {
        RESET("\u001b[0m"),
        BLACK("\u001b[30m"),
        RED("\u001b[31m"),
        GREEN("\u001b[32m"),
        YELLOW("\u001b[33m"),
        BLUE("\u001b[34m"),
        PURPLE("\u001b[35m"),
        CYAN("\u001b[36m"),
        WHITE("\u001b[37m");

        String prefix = null;

        Colours(String prefix) {
            this.prefix = prefix;
        }
    }

    public enum Directions {
        UP(-1, 0),

        DOWN(1, 0),

        LEFT(0, -1),

        RIGHT(0, 1);

        Directions(int deltaY, int deltaX) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }
        final int deltaY;
        final int deltaX;
    }

    public static class Chances {

        private static final HashMap<Class<?>, HashMap<Class<?>, Integer>> container = new HashMap<>() {{
           put(Carnivore_Wolf.class, new HashMap<>() {{
               put(Carnivore_Wolf.class, 0);
               put(Carnivore_Snake.class, 0);
               put(Carnivore_Fox.class, 0);
               put(Carnivore_Bear.class, 0);
               put(Carnivore_Eagle.class, 0);
               put(Herbivore_Horse.class, 10);
               put(Herbivore_Deer.class, 15);
               put(Herbivore_Rabbit.class, 60);
               put(Herbivore_Mouse.class, 80);
               put(Herbivore_Goat.class, 60);
               put(Herbivore_Sheep.class, 70);
               put(Herbivore_Boar.class, 15);
               put(Herbivore_Buffalo.class, 10);
               put(Herbivore_Duck.class, 40);
               put(Herbivore_Larva.class, 0);
               put(_Plant.class, 0);
           }});

            put(Carnivore_Snake.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 15);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 20);
                put(Herbivore_Mouse.class, 40);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 10);
                put(Herbivore_Larva.class, 0);
                put(_Plant.class, 0);
            }});

            put(Carnivore_Fox.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 70);
                put(Herbivore_Mouse.class, 90);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 60);
                put(Herbivore_Larva.class, 40);
                put(_Plant.class, 0);
            }});

            put(Carnivore_Bear.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 80);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 40);
                put(Herbivore_Deer.class, 80);
                put(Herbivore_Rabbit.class, 80);
                put(Herbivore_Mouse.class, 90);
                put(Herbivore_Goat.class, 70);
                put(Herbivore_Sheep.class, 70);
                put(Herbivore_Boar.class, 50);
                put(Herbivore_Buffalo.class, 20);
                put(Herbivore_Duck.class, 10);
                put(Herbivore_Larva.class, 0);
                put(_Plant.class, 0);
            }});

            put(Carnivore_Eagle.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 10);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 90);
                put(Herbivore_Mouse.class, 90);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 80);
                put(Herbivore_Larva.class, 0);
                put(_Plant.class, 0);
            }});

            put(Herbivore_Horse.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 0);
                put(Herbivore_Mouse.class, 0);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 0);
                put(Herbivore_Larva.class, 0);
                put(_Plant.class, 100);
            }});

            put(Herbivore_Deer.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 0);
                put(Herbivore_Mouse.class, 0);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 0);
                put(Herbivore_Larva.class, 0);
                put(_Plant.class, 100);
            }});

            put(Herbivore_Rabbit.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 0);
                put(Herbivore_Mouse.class, 0);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 0);
                put(Herbivore_Larva.class, 0);
                put(_Plant.class, 100);
            }});

            put(Herbivore_Mouse.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 0);
                put(Herbivore_Mouse.class, 0);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 0);
                put(Herbivore_Larva.class, 90);
                put(_Plant.class, 100);
            }});

            put(Herbivore_Goat.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 0);
                put(Herbivore_Mouse.class, 0);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 0);
                put(Herbivore_Larva.class, 0);
                put(_Plant.class, 100);
            }});

            put(Herbivore_Sheep.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 0);
                put(Herbivore_Mouse.class, 0);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 0);
                put(Herbivore_Larva.class, 0);
                put(_Plant.class, 100);
            }});

            put(Herbivore_Boar.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 0);
                put(Herbivore_Mouse.class, 50);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 0);
                put(Herbivore_Larva.class, 90);
                put(_Plant.class, 100);
            }});

            put(Herbivore_Buffalo.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 0);
                put(Herbivore_Mouse.class, 0);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 0);
                put(Herbivore_Larva.class, 0);
                put(_Plant.class, 100);
            }});

            put(Herbivore_Duck.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 0);
                put(Herbivore_Mouse.class, 0);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 0);
                put(Herbivore_Larva.class, 90);
                put(_Plant.class, 100);
            }});

            put(Herbivore_Larva.class, new HashMap<>() {{
                put(Carnivore_Wolf.class, 0);
                put(Carnivore_Snake.class, 0);
                put(Carnivore_Fox.class, 0);
                put(Carnivore_Bear.class, 0);
                put(Carnivore_Eagle.class, 0);
                put(Herbivore_Horse.class, 0);
                put(Herbivore_Deer.class, 0);
                put(Herbivore_Rabbit.class, 0);
                put(Herbivore_Mouse.class, 0);
                put(Herbivore_Goat.class, 0);
                put(Herbivore_Sheep.class, 0);
                put(Herbivore_Boar.class, 0);
                put(Herbivore_Buffalo.class, 0);
                put(Herbivore_Duck.class, 0);
                put(Herbivore_Larva.class, 0);
                put(_Plant.class, 100);
            }});
        }};

        public static int getChance(Class<?> who, Class<?> whom) {
            return container.get(who).get(whom);
        }
        public static HashMap<Class<?>, Integer> getChance(Class<?> who) {
            return container.get(who);
        }
    }

}
