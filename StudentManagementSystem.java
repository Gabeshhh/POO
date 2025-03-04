import java.util.*;

// Abstract class Person
abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

// Student class
class Student extends Person {
    private String studentID;
    private List<Double> grades;

    public Student(String name, int age, String studentID) {
        super(name, age);
        this.studentID = studentID;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double getAverageGrade() {
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public String getStudentID() { return studentID; }
}

// GraduateStudent class
class GraduateStudent extends Student {
    public GraduateStudent(String name, int age, String studentID) {
        super(name, age, studentID);
    }

    @Override
    public double getAverageGrade() {
        return super.getAverageGrade() + 5; // Exemple de pondération pour les diplômés
    }
}

// UndergraduateStudent class
class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name, int age, String studentID) {
        super(name, age, studentID);
    }
}

// Course class
class Course {
    private String courseName;
    private String courseCode;
    private int creditHours;
    private List<Student> students;

    public Course(String courseName, String courseCode, int creditHours) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return students;
    }

    // Ajout des getters pour éviter les warnings
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public int getCreditHours() { return creditHours; }
}

// Enrollment class
class Enrollment {
    public Enrollment(Student student, Course course) {
        course.enrollStudent(student);
    }
}

// Main class for testing
public class StudentManagementSystem {
    public static void main(String[] args) {
        Student student1 = new UndergraduateStudent("Alice", 20, "S123");
        Student student2 = new GraduateStudent("Bob", 25, "S456");

        Course course1 = new Course("Mathematics", "MATH101", 3);

        // Enregistrement des étudiants sans créer de variables inutilisées
        new Enrollment(student1, course1);
        new Enrollment(student2, course1);

        student1.addGrade(85);
        student1.addGrade(90);
        student2.addGrade(80);
        student2.addGrade(75);

        // Affichage des informations pour éviter les warnings
        System.out.println("Course: " + course1.getCourseName() + " (" + course1.getCourseCode() + "), " + course1.getCreditHours() + " credits");
        System.out.println(student1.getName() + " (" + student1.getStudentID() + ") Average Grade: " + student1.getAverageGrade());
        System.out.println(student2.getName() + " (" + student2.getStudentID() + ") Average Grade: " + student2.getAverageGrade());
        System.out.println("Total students enrolled in " + course1.getCourseName() + ": " + course1.getEnrolledStudents().size());
    }
}
