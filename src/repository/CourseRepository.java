package repository;

import exception.CourseNotFoundException;
import model.Course;
import service.CourseService;
import service.CourseServiceImp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRepository {
    static CourseService courseService = new CourseServiceImp();
    static List<Course> courseList = new ArrayList<>(List.of(
            new Course(Course.generateId(), "DevOps Engineering", new String[]{"Jame", "MEME"}, new String[]{"Basic Software Development Concept"}, courseService.formatLocalDate()),
            new Course(Course.generateId(), "Spring boot Framework", new String[]{"Sophy"}, new String[]{"Basic Java", "OOP Concept"}, courseService.formatLocalDate()),
            new Course(Course.generateId(), "Java", new String[]{"Sokpheng"}, new String[]{"Basic C/C++"}, courseService.formatLocalDate())
    ));
    public static void addCourse() {
        try {
            int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            System.out.print("[+] Insert course title: ");
            String title = new Scanner(System.in).nextLine();
            for (int i = 0; i < title.length(); i++) {
                if (Character.isDigit(title.charAt(i))) {
                    throw new CourseNotFoundException("Invalid course title: " + title);
                }
            }
            System.out.print("[+] Insert Instructor names: ");
            String[] instructors = new Scanner(System.in).nextLine().split(",");
            for (int number : numbers) {
                for (String instructor : instructors) {
                    if (instructor.contains(String.valueOf(number))) {
                        throw new CourseNotFoundException("Invalid input instructor: " + instructor);
                    }
                }
            }
            System.out.print("[+] Insert course requirement: ");
            String[] requirements = new Scanner(System.in).nextLine().split(",");
            for (int number : numbers) {
                for (String requirement : requirements) {
                    if (requirement.contains(String.valueOf(number))) {
                        throw new CourseNotFoundException("Invalid input instructor: " + requirement);
                    }
                }
            }
            courseList.add(new Course(Course.generateId(), title, instructors, requirements, courseService.formatLocalDate()));
        } catch (CourseNotFoundException courseNotFoundException) {
            System.out.println(courseNotFoundException.getMessage());
        }
    }
    public static List<Course> getAllCourses() {
        return courseList;
    }
}
