package lab3;

public class TestRectangle {
    Rectangle rec1;
    Rectangle rec2;

    public TestRectangle() {
        rec1 = new Rectangle(4, 5);
        rec2 = new Rectangle("black", true, 5, 5);
        if (rec1.equals(rec2)) {
            System.out.println("Rec1 == Rec2");
        } else {
            System.out.println("Rec != Rec2");
        }
    }

    public static void main(String[] args) {
        new TestRectangle();
    }
}
