/**
 * Список возможных цветов игроков.
 */
public enum PlayerColor {
    WHITE("white"),
    ORANGE("orange"),
    BLUE("blue"),
    RED("red");

    private String color;

    PlayerColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
