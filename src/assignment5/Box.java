package assignment5;

public class Box {
    public int width;
    public int height;
    public int depth;

    public Box(Box ob) { width = ob.width;height = ob.height;depth = ob.depth;}

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box() {
        this.width = -1;
        this.height = -1;
        this.depth = -1;
    }

    public Box(int len) {
        width = height = depth = len;
    }

    int getVolume() {
        return width*height*depth;
    }
}
