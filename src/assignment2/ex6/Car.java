package assignment2.ex6;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Car {
    double x, y, dir;

    public Car(double xx, double yy, double d) {
        x = xx;
        y = yy;
        dir = d;
    }

    void move(double len){
        x += len*cos(dir);
        y += len*sin(dir);
    };
    void setDir(double nd){
        dir = nd;
    };
}
