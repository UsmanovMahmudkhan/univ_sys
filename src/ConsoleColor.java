
public enum ConsoleColor {
    RESET("\u001B[0m"),
    ELECTRIC_PURPLE("\u001B[38;5;129m"),
    HOT_PINK("\u001B[38;5;198m"),
    NEON_BLUE("\u001B[38;5;45m"),
    LIME_GREEN("\u001B[38;5;118m"),
    SUNSET_ORANGE("\u001B[38;5;208m"),
    GOLD("\u001B[38;5;220m"),
    TURQUOISE("\u001B[38;5;51m"),
    LAVENDER("\u001B[38;5;183m"),
    CYBER_YELLOW("\u001B[38;5;226m"),
    DEEP_ROSE("\u001B[38;5;197m"),
    MINT("\u001B[38;5;121m");

    private final String code;

    ConsoleColor(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String apply(String text) {
        return code + text + RESET.code;
    }
}