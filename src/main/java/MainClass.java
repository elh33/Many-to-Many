import dao.CourseDao;
import dao.StudentDao;
import daoImpl.CourseDaoImpl;
import daoImpl.StudentDaoImpl;
import models.Course;
import models.Student;

public class MainClass {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();

        try {
            // Create students
            Student student1 = new Student("John Doe", "john@example.com");
            Student student2 = new Student("Jane Smith", "jane@example.com");

            // Create courses
            Course course1 = new Course("Java Programming", "Learn Java programming language");
            Course course2 = new Course("Database Systems", "Introduction to database systems");
            Course course3 = new Course("Web Development", "Web development with HTML, CSS, and JavaScript");

            // Save students to database first
            studentDao.addStudent(student1);
            studentDao.addStudent(student2);

            // Save courses to database
            courseDao.addCourse(course1);
            courseDao.addCourse(course2);
            courseDao.addCourse(course3);

            // Assign courses to students
            student1.addCourse(course1);
            student1.addCourse(course2);
            student2.addCourse(course2);
            student2.addCourse(course3);

            // Update students with their course relationships
            studentDao.updateStudent(student1);
            studentDao.updateStudent(student2);

            System.out.println("Data saved successfully!");

            // Retrieve and display all students with their courses
            System.out.println("\nAll Students with their courses:");
            for (Student student : studentDao.getAllStudents()) {
                System.out.println(student);
                System.out.println("Enrolled courses:");
                for (Course course : student.getCourses()) {
                    System.out.println("  - " + course.getTitle());
                }
                System.out.println();
            }

            // Retrieve and display all courses with their students
            System.out.println("\nAll Courses with their students:");
            for (Course course : courseDao.getAllCourses()) {
                System.out.println(course);
                System.out.println("Enrolled students:");
                for (Student student : course.getStudents()) {
                    System.out.println("  - " + student.getName());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            ((StudentDaoImpl) studentDao).close();
            ((CourseDaoImpl) courseDao).close();
        }
    }
}