public final class Constants {

    public enum Strings {
        ENTER_X("Please, enter field param X:"),
        ENTER_Y("Please, enter field param Y:"),
        TOO_BIG("Value is too big"),
        MUST_BE_POSITIVE("Value must be positive"),
        WRONG_VALUE("Wrong value entered!"),
        DEF_SQUARE("Do you want to use default terrain square 25 x 25?"),
        DEFAULT_QUANTTIES("Use recommended quantities of creatures for this square?")

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

}
