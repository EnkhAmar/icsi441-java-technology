package lab3;

// @student: G.Enkh-Amar /18b1num0399/
/*
13.10 (Enable Rectangle comparable) Rewrite the Rectangle class in Listing 13.3 to
extend GeometricObject and implement the Comparable interface. Override
the equals method in the Object class. Two Rectangle objects are equal if
their areas are the same. Draw the UML diagram that involves Rectangle,
GeometricObject, and Comparable.
 */

public class Rectangle extends GeometricObject implements Comparable{
    double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle(String color, boolean filled, double a, double b) {
        super(color, filled);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public int compareTo(Object o) {
        if (this.getArea() > ((Rectangle) o).getArea()) {
            return 1;
        } else if (this.getArea() < ((Rectangle) o).getArea()) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getArea() == ((Rectangle) obj).getArea();
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return 2 * (a + b);
    }
}
