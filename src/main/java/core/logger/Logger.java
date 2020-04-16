package core.logger;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Logger {
    public static class Color {
        public static final String RED = "\u001B[31m";
        public static final String BLUE = "\u001B[34m";
        public static final String RESET = "\u001B[0m";
    }
}
