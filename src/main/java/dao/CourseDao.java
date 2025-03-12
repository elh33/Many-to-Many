package dao;

import models.Course;
import java.util.List;

public interface CourseDao {
    void addCourse(Course course);
    Course getCourse(Long id);
    List<Course> getAllCourses();
    void updateCourse(Course course);
    void deleteCourse(Course course);
}