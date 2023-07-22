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
        DEF_SQUARE("Do you want to use default terrain square 25 x 25?"),
        DEF_QUANTTIES("Use recommended quantities of creatures for this square?"),
        START("Simulation will start in:"),
        DEF_STEPS("Do you want to use default value of steps?"),
        ENTER_STEPS("Please, enter steps number:")

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

           }});
        }};
    }

}
