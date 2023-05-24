package assignment9;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/*
Магистрантад элсэх бакалаврын боловсролтой элсэгчдийн рейтингийг тогтоохдоо дипломын голч оноог
мэргэжлээрээ ажилласан коэффициентээр үржиж тодорхойлно. Үүнд, мэргэжлээр ажиллаагүй бол 1-ээр,
2-оос цөөн жил ажилласан бол 13-аар, 2-оос 5 жил хүртэл ажилласан бол 16-аар тус тус үржинэ.
Дипломын голч оноо (3-аас 5 хооронд) өгөгдсөн бол рейтингийг тодорхойлж хэрэв 45-аас дээш бол тэнцсэн
гэх ба эсрэг тохиолдолд тэнцээгүй гэж хариулна. Програмд элсэгчдийн голч оноонуудыг оруулахдаа
санамсаргүй тоо санагч ашиглаарай.
 */
public class Exercise2 {
    public static void main(String[] args) {
        // Create a random number generator
        Random random = new Random();

        // Generate GPAs and experience years for 10 applicants using functional programming approach
        double[] gpas = generateGPAs(random, 10);
        int[] experienceYears = generateExperienceYears(random, 10);

        // Calculate ratings and determine pass/fail for each applicant
        String[] results = DoubleStream.of(gpas)
                .mapToObj(gpa -> calculateRating(gpa, experienceYears[0]))
                .map(rating -> (rating > 45) ? "Passed" : "Failed")
                .toArray(String[]::new);

        // Print the details for each applicant
        for (int i = 0; i < gpas.length; i++) {
            System.out.println("Applicant " + (i+1) + ": GPA = " + gpas[i] +
                    ", Experience Years = " + experienceYears[i] +
                    ", Result = " + results[i]);
        }
    }

    public static double[] generateGPAs(Random random, int count) {
        return random.doubles(count, 1, 5)
                .toArray();
    }

    public static int[] generateExperienceYears(Random random, int count) {
        return random.ints(count, 0, 6)
                .toArray();
    }

    public static double calculateRating(double gpa, int experienceYears) {
        double coefficient;

        if (experienceYears == 0) {
            coefficient = 1;
        } else if (experienceYears < 2) {
            coefficient = 13;
        } else if (experienceYears <= 5) {
            coefficient = 16;
        } else {
            coefficient = 16;
        }

        return gpa * coefficient;
    }

}
