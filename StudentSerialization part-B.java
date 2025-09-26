import java.io.*;
 
class Student implements Serializable {
    private static final long serialVersionUID = 1L;  
    int studentID;
    String name;
    String grade;

    public Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public void display() {
        System.out.println("ID: " + studentID + ", Name: " + name + ", Grade: " + grade);
    }
}

public class StudentSerialization {
    public static void main(String[] args) {
       
        String filename = System.getProperty("user.home") + File.separator + "student.ser";
 
        Student s1 = new Student(101, "Priya", "A");
 
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(s1);
            System.out.println("Student object serialized and saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Student s2 = (Student) in.readObject();
            System.out.println("Deserialized Student object:");
            s2.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
