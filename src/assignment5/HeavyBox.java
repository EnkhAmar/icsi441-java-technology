package assignment5;

import java.util.ArrayList;

public class HeavyBox extends Box{
    public int weight;

    public HeavyBox(Box ob, int weight) {
        super(ob);
        this.weight = weight;
    }

    public HeavyBox(int width, int height, int depth, int weight) {
        super(width, height, depth);
        this.weight = weight;
    }

    public HeavyBox(int weight) {
        this.weight = weight;
    }

    public HeavyBox(int len, int weight) {
        super(len);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HeavyBox{width=" + width + ", height=" + height + ", depth=" + depth + ", weight=" + weight + "}";
    }
}
