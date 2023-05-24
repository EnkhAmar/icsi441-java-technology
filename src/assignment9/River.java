package assignment9;

import java.io.*;

class River implements Serializable {
    private String name;
    private double length;
    private double depth;

    public River(String name, double length, double depth) {
        this.name = name;
        this.length = length;
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "River{name='" + name + "', length=" + length + ", depth=" + depth + "}";
    }
}