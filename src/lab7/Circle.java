package lab7;

/*
К ширхэг тойрог объект үүсгэн ямар нэг цуглуулгад хадгална.
1. Эдгээр тойрог объектуудыг талбайг хэвлэнэ. Ингэхдээ iterator хэрэглэнэ.
2. Ижил радиустай тойргуудыг хэвлэнэ.
3. Тойргуудын талбайны утгаар нь урвуугаар эрэмбэлнэ.
 */
public class Circle implements Comparable<Circle> {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.round((Math.PI * radius * radius) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "area=" + getArea() +
                '}';
    }

    @Override
    public int compareTo(Circle o) {
        return this.radius - o.radius;
    }
}
