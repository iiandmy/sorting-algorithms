package by.budevich.entity;

public class Ball {
    private int size;
    private String color;
    private String type;
    private static final int MIN_BALL_SIZE = 1;
    private static final int MAX_BALL_SIZE = 6;

    public int getSize() {
        return this.size;
    }
    public String getColor() {
        return this.color;
    }
    public String getType() {
        return this.type;
    }

    public void setSize(int size) {
        if (size < MIN_BALL_SIZE || size > MAX_BALL_SIZE) {
            return;
        }
        this.size = size;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setType(String type) {
        this.type = type;
    }
}
