package ua.opnu;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Student[] filter(final Student[] students,
                                   final Predicate<Student> predicate) {
        return Arrays.stream(students)
                .filter(predicate)
                .toArray(Student[]::new);
    }
    public static Student[] filterStudents(final Student[] students,
                                           final Predicate<Student> pred1,
                                           final Predicate<Student> pred2) {
        return Arrays.stream(students)
                .filter(pred1.and(pred2)) // обидва предикати мають бути true
                .toArray(Student[]::new);
    }
    public static String[] stringify(final int[] numbers,
                                     final Function<Integer,
                                             String> converter) {
        return Arrays.stream(numbers)
                .mapToObj(converter::apply)
                .toArray(String[]::new);
    }


    // Метод, який приймає Predicate та Consumer
    public static void processIf(final int[] numbers,
                                 final Predicate<Integer> condition,
                                 final Consumer<Integer> action) {
        for (int num : numbers) {
            if (condition.test(num)) {   // якщо умова виконується
                action.accept(num);      // виконуємо дію
            }
        }
    }

    static void main() {
        // Завдання 1
        System.out.println("Завдання 1");
        IntPredicate isPrime = n -> {
            if (n < 2) {
                return false;
            }
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };
        System.out.println(isPrime.test(2));
        System.out.println(isPrime.test(15));
        System.out.println(isPrime.test(17));


        // Завдання 2
        System.out.println("\nЗавдання 2");
        Student[] students = {
                new Student("Дмитро", "УП", new int[]{80, 75, 90}),
                new Student("Максим", "УП", new int[]{55, 70, 60}),
                new Student("Марія", "УІ", new int[]{40, 85, 77}),
                new Student("Вікторія", "УІ", new int[]{95, 90, 88})
        };

        Predicate<Student> noDebts2 = s ->
                Arrays.stream(s.getMarks()).noneMatch(m -> m < 60);

        Student[] filtered = filter(students, noDebts2);

        for (Student s : filtered) {
            System.out.println(s.getName() + " з групи " + s.getGroup());
        }

        // Завдання 3
        System.out.println("\nЗавдання 3");

        // Предикат 1
        Predicate<Student> noDebts3 = student ->
                Arrays.stream(student.getMarks()).allMatch(mark -> mark >= 60);
        // Предикат 2
        Predicate<Student> groupA1 = student -> "УП".equals(student.getGroup());

        Student[] filteredStudents =
                filterStudents(students, noDebts3, groupA1);

        System.out.println("Студенти без заборгованостей з групи УП:");
        for (Student s : filteredStudents) {
            System.out.println(s.getName());
        }

        // Завдання 4
        System.out.println("\nЗавдання 4");

        Student4[] studentArray = {
                new Student4("Владислав", "Карлінський",
                        "УП", new int[]{75, 80, 90}),
                new Student4("Вікторія", "Мартиненко",
                        "УІ", new int[]{60, 65, 70}),
                new Student4("Олег", "Гордієнко",
                        "УП", new int[]{85, 90, 95})
        };

        Consumer<Student4> printFullName = student ->
                System.out.println(student.getLastName()
                        + " " + student.getFirstName());

        Arrays.stream(studentArray).forEach(printFullName);

        // Завдання 5
        System.out.println("\nЗавдання 5");
        int[] numbers5 = {10, 15, 20, 25, 30, 35};

        Predicate<Integer> isMultipleOf10 = n -> n % 10 == 0;
        Consumer<Integer> printNumber = n -> System.out.println("Число: " + n);

        System.out.println("Числа, кратні 10:");
        processIf(numbers5, isMultipleOf10, printNumber);


        // Масив для 6 і 7 завдань
        int[] numbers67 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


        // Завдання 6
        System.out.println("\nЗавдання 6");

        Function<Integer, Integer> powerOfTwo = n -> (int) Math.pow(2, n);

        System.out.println("2^n для чисел з масиву:");
        for (int num : numbers67) {
            int result = powerOfTwo.apply(num);
            System.out.println("2^" + num + " = " + result);
        }

        // Завдання 7
        System.out.println("\nЗавдання 7");
        Function<Integer, String> numberToString = n -> switch (n) {
            case 0 -> "нуль";
            case 1 -> "один";
            case 2 -> "два";
            case 3 -> "три";
            case 4 -> "чотири";
            case 5 -> "п’ять";
            case 6 -> "шість";
            case 7 -> "сім";
            case 8 -> "вісім";
            case 9 -> "дев’ять";
            default -> "";
        };

        String[] stringNumbers = stringify(numbers67, numberToString);

        System.out.println("Числа у вигляді рядків:");
        for (String s : stringNumbers) {
            System.out.println(s);
        }
    }
}
