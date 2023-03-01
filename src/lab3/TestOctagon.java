package lab3;

public class TestOctagon {
    Octagon oct1;
    Octagon oct2;
    public TestOctagon() throws CloneNotSupportedException {
        oct1 = new Octagon("black", true, 5);
//        oct2 = new Octagon("white", false, 4);
        oct2 = (Octagon) oct1.clone();
        if (oct1.compareTo(oct2) > 0) {
            System.out.println("oct1");
        } else if (oct1.compareTo(oct2) < 0) {
            System.out.println("oct2");
        } else {
            System.out.println("tentsuu");
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        new TestOctagon();
    }
}
