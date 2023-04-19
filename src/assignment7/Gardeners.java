package assignment7;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// @student: G.Enkh-Amar
/* Бодлого No2.
Хоосон газар (хоёр хэмжээст массив) байгуулах цэцэрлэгийн план зураг өгөгдөв.
Энэ цэцэрлэгийг хоёр цэцэрлэгч хийнэ. Эхний цэцэрлэгч цэцэрлэгийн зүүн дээд
булангаас эхлэн зүүнээс баруун тийш нэг эгнээ явж доод эгнээлүү шилжинэ. Хоёрдахь
цэцэрлэгч баруун доод булангаас эхлэн доороос дээш нэг эгнээ яваад зүүн тийш
шилжинэ. Тэд нэг нэгийнхээ явсан замаар явахгүй, хэрэв нөгөө цэцэрлэгч явсан
байвал алгасч цааш явна. Цэцэрлэгчид нэгэн зэрэг ажиллана. Цэцэрлэгч нарын ажлыг
загварчилдаг олон трэдэт програм зохио.
 */
public class Gardeners {
    private static final int ROWS = 20;
    private static final int COLS = 80;

    public static void main(String[] args) throws InterruptedException {
        int[][] land = new int[ROWS][COLS];
        Thread t1 = new Thread(new Gardener1(land));
        Thread t2 = new Thread(new Gardener2(land));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        printLand(land);
    }

    private static void printLand(int[][] land) {
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    System.out.print("- ");
                } else if (land[i][j] == 1) {
                    System.out.print("1 ");
                } else if (land[i][j] == 2) {
                    System.out.print("2 ");
                }
            }
            System.out.println();
        }
    }

    private static class Gardener1 implements Runnable {
        private final int[][] land;

        public Gardener1(int[][] land) {
            this.land = land;
        }

        @Override
        public void run() {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (land[i][j] == 0) {
                        synchronized (land) {
                            land[i][j] = 1;
                        }
                    }
                }
            }
        }
    }

    private static class Gardener2 implements Runnable {
        private final int[][] land;

        public Gardener2(int[][] land) {
            this.land = land;
        }

        @Override
        public void run() {
            for (int i = COLS - 1; i >= 0; i--) {
                for (int j = ROWS - 1; j >= 0; j--) {
                    if (land[j][i] == 0) {
                        synchronized (land) {
                            land[j][i] = 2;
                        }
                    }
                }
            }
        }
    }
}