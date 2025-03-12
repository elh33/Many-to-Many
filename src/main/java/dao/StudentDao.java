package dao;

import models.Student;
import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    Student getStudent(Long id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(Student student);
}