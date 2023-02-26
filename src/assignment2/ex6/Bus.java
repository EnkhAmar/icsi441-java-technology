package assignment2.ex6;
// @student: G.Enkh-Amar /18b1num0399/
/*
Автомашинд байрлалыг илэрхийлдэг координатууд, хөдөлгөөний чиглэлийг илэрхийлдэг
өнцөг гэсэн утгуудаар тодорхойлогдоно. Анхны байрлалаас сонгосон чиглэлд хөдөлж явна
(явж байхдаа чиглэлээ өөр ямар ч чиглэл лүү өөрчилнө)
public classCar{
    double x, y, dir;
    public Car (double xx, double yy, double d);
    void move(double len){
        x += len*cos(dir);
        y += len*sin(dir);
    };
    void setDir(double nd){
        dir = nd;
        };
    };
Тэгвэл автобус классыг тодорхойл. Автомашинд байдаг бүх хувьсагчаас гадна автобусын хувьд
зорчигчдын тоо, зорчигчдын төлсөн автобусны төлбөрийн хэмжээ (эхлээд  энэ хувьсагчийн утга
0 байсан)-г хадгалах хувьсагчуудтай. Зорчигчид бууж суух үед зорчигчдын тоо өөрчлөгдөнө.
Автобусны олох орлогын хэмжээ нь зорчсон хүмүүсийн тоо болон тэд хэдэн буудал зорчихоос хамаарна.
Тухайн автобусны нэг чиглэлд явахад олох орлогын хэмжээ (мөнгө)-г тодорхойл.
 */
public class Bus extends Car {
    int passengers, paidAmount;
    final static int ticket = 500;
    public Bus(double xx, double yy, double d) {
        super(xx, yy, d);
        passengers = 0;
        paidAmount = 0;
    }

    void getIn(int num) {
        passengers += num;
        paidAmount += ticket * num;
    }

    void getOut(int num) {
        passengers -= num;
    }

    int calculateIncome() {
        return paidAmount;
    }

    public static void main(String[] args) {
        Bus bus = new Bus(0, 0, 0);
        bus.setDir(Math.PI * 2);
        bus.getIn(2);
        bus.move(200);
        bus.getIn(3);
        bus.move(100);
        bus.getOut(bus.passengers);
        System.out.println("Bus Income: " + bus.calculateIncome());
    }
}
