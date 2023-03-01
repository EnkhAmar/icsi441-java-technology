package lab3;

// @student: G.Enkh-Amar /18b1num0399/
/*
*13.11 (The Octagon class) Write a class named Octagon that extends
GeometricObject  and implements the Comparable and Cloneable interfaces. Assume all eight sides of the octagon are of equal length. The area can be
computed using the following formula:
area = (2 + 4/Math.sqrt(2)) * side * side
The Octagon class has a private double data field named side with its getter and
setter methods. The class has a no-arg constructor that creates an Octagon with
side 0, and a constructor to create an Octagon with a specified side.
Draw the UML diagram that involves Octagon, GeometricObject, Comparable,
and Cloneable. Write a test program that creates an Octagon object with side
value 5 and displays its area and perimeter. Create a new object using the clone
method, and compare the two objects using the compareTo method.
 */
public class Octagon extends GeometricObject implements Comparable, Cloneable {
    double side;

    public Octagon(double side) {
        this.side = side;
    }

    public Octagon(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public int compareTo(Object o) {
        if (this.getArea() > ((Octagon) o).getArea()) {
            return 1;
        } else if (this.getArea() < ((Octagon) o).getArea()) {
            return -1;
        }
        return 0;
    }

    @Override
    public double getArea() {
        return (2 + 4/Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public String toString() {
        return "Octagon{" +
                "side=" + side +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Octagon octagonClone = (Octagon) super.clone();
        return octagonClone;
    }
}
