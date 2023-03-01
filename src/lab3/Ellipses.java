package lab3;

public class Ellipses extends GeometricObject {
    double r1, r2;

    public Ellipses() {
        this(1, 1);
    }
    public Ellipses(double r1, double r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    public Ellipses(String color, boolean filled, double r1, double r2) {
        super(color, filled);
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public double getArea() {
        return r1 * r2 * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * (r1 + r2);
    }

    @Override
    public String toString() {
        return "Ellipses{" +
                "r1=" + r1 +
                ", r2=" + r2 +
                ", талбай=" + getArea() +
                ", периметер=" + getPerimeter() +
                ", будагсан эсэх=" + getColor() +
                '}';
    }
}
