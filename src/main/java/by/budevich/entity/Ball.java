package by.budevich.entity;

public class Ball {
    private static final int MIN_BALL_SIZE = 1;
    private static final int MAX_BALL_SIZE = 6;
    private static final int DEFAULT_SIZE_VALUE = 3;
    private static final String DEFAULT_COLOR_VALUE = "Green";
    private static final String DEFAULT_TYPE_VALUE = "Basketball";
    private int size;
    private String color;
    private String type;

    public Ball() {
        this.setColor(DEFAULT_COLOR_VALUE);
        this.setType(DEFAULT_TYPE_VALUE);
        this.setSize(DEFAULT_SIZE_VALUE);
    }

    public Ball(int size, String color, String type) {
        this.setSize(size);
        this.setColor(color);
        this.setType(type);
    }

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
            this.size = DEFAULT_SIZE_VALUE;
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
