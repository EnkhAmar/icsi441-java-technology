package lab3;

public class Ellipses extends GeometricObject implements  Colorable {
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

    public double getR1() {
        return r1;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
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

    @Override
    public void howToColor() {
        System.out.println("Хүрээний шугамыг буд");
    }
}
