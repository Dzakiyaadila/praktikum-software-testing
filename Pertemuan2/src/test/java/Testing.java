import org.example.Course;
import org.example.Student;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class Testing {
    static Course course;
    static List<Student> students;
    static Student student;

    @BeforeAll
    static void initClass() {
        course = new Course("SVPL33", "PPPL");
        students = new ArrayList<>();
    }

    @AfterAll
    static void cleanClass() {
        course = null;
        students.clear();
    }

//    @AfterEach

    @BeforeEach
    void initMethod () {
        student = new Student("542", "wiwi");
        students.add (student);

    }

    @Test
    void testEnrollStudent() {

        course.enrollStudent(student);

        Assertions.assertEquals(1, course.getStudentCount());
        Assertions.assertTrue(course.isStudentEnrolled(student));
    }

    @Test
    void testUnenrolledStudent() {
        course.enrollStudent(student);

        course.unenrollStudent(student);

        Assertions.assertEquals(0, course.getStudentCount());
        Assertions.assertFalse(course.isStudentEnrolled(student));

    }

    @AfterAll
    static void cleanMethod() {
        course = null;
        students.remove(student);
    }
}

