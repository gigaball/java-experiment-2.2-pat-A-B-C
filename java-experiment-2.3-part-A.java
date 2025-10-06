import java.util.*;
import java.util.stream.*;
public class StreamStudents {
    static class Student {
        String name;
        double marks;

        Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return String.format("%-10s | Marks: %.2f", name, marks);
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Amit", 82.5),
            new Student("Neha", 74.0),
            new Student("Rahul", 91.0),
            new Student("Sneha", 78.5),
            new Student("Karan", 69.5)
        );

        System.out.println("All Students:");
        students.forEach(System.out::println);

        System.out.println("\nStudents Scoring Above 75%, Sorted by Marks:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))
                .map(s -> s.name)
                .forEach(System.out::println);
    }
}
