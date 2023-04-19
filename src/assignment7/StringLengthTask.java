package assignment7;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// @student G.Enkh-Amar
/* Бодлого No1.
Тэмдэгт мөрүүд агуулдаг массив өгөгдөв. Энэ массивын тэмдэгт мөр болгоны уртыг параллель програмчилал ашиглан ол.
Хоосон тэмдэгт мөрийг алгасна. Жишээлбэл, оролтын массив ["", "", "cse", "box", "", "homework", "", "15", "" ]
гэвэл гаралт нь: [ 3, 3, 8, 2].
 */

public class StringLengthTask extends RecursiveTask<int[]> {

    private final String[] strings;
    private final int threshold;

    public StringLengthTask(String[] strings, int threshold) {
        this.strings = strings;
        this.threshold = threshold;
    }

    @Override
    protected int[] compute() {
        if (strings.length <= threshold) {
            return computeSequentially();
        } else {
            int mid = strings.length / 2;
            StringLengthTask leftTask = new StringLengthTask(Arrays.copyOfRange(strings, 0, mid), threshold);
            StringLengthTask rightTask = new StringLengthTask(Arrays.copyOfRange(strings, mid, strings.length), threshold);
            leftTask.fork();
            int[] rightResult = rightTask.compute();
            int[] leftResult = leftTask.join();
            return merge(leftResult, rightResult);
        }
    }

    private int[] computeSequentially() {
        int[] lengths = new int[strings.length];
        int count = 0;
        for (String s : strings) {
            if (!s.isEmpty()) {
                lengths[count] = s.length();
                count++;
            }
        }
        return Arrays.copyOf(lengths, count);
    }

    private int[] merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        System.arraycopy(a, 0, merged, 0, a.length);
        System.arraycopy(b, 0, merged, a.length, b.length);
        return merged;
    }

    public static void main(String[] args) {
        String[] strings = {"", "", "cse", "box", "", "homework", "", "15", ""};
        int threshold = 2;
        StringLengthTask task = new StringLengthTask(strings, threshold);
        ForkJoinPool pool = new ForkJoinPool();
        int[] lengths = pool.invoke(task);
        System.out.println(Arrays.toString(lengths));
    }
}
