package service;

import exception.CourseNotFoundException;
import model.Course;
import java.util.List;

public interface CourseService {
    String formatLocalDate();
    void addNewCourse();
    void listAllCourses();
    List<Course> getAllCourses();
    Course getCourseById(Integer id) throws CourseNotFoundException;
    Course getCourseByTitle(String title) throws CourseNotFoundException;
    void removeCourseByID(Integer id) throws CourseNotFoundException;
}
