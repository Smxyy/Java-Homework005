import exception.CourseNotFoundException;
import model.Course;
import service.CourseService;
import service.CourseServiceImp;
import view.View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private final static CourseService courseService = new CourseServiceImp();
    public static void main(String[] args) {
        while (true) {
            View.menu();
            try {
                Integer option = View.inputChoice();
                switch (option) {
                    case 1 -> courseService.addNewCourse();
                    case 2 -> courseService.listAllCourses();
                    case 3 -> {
                        System.out.println("=".repeat(160));
                        try{
                            System.out.print("Find course by ID: ");
                            Integer id = new Scanner(System.in).nextInt();
                            courseService.getCourseById(id);
                        }catch (CourseNotFoundException courseNotFoundException) {
                            System.out.println(courseNotFoundException.getMessage());
                        }
                        System.out.println("=".repeat(160));
                    }
                    case 4 -> {
                        System.out.println("=".repeat(160));
                        try{
                            System.out.print("Find course by Title: ");
                            String title = new Scanner(System.in).nextLine().toLowerCase().trim();
                            courseService.getCourseByTitle(title);
                        }catch (CourseNotFoundException courseNotFoundException) {
                            System.out.println(courseNotFoundException.getMessage());
                        }
                        System.out.println("=".repeat(160));
                    }
                    case 5 -> {
                        try {
                            System.out.print("Remove course by ID: ");
                            Integer id = new Scanner(System.in).nextInt();
                            courseService.removeCourseByID(id);
                        }catch (CourseNotFoundException courseNotFoundException) {
                            System.out.println(courseNotFoundException.getMessage());
                        }
                    }
                    case 0,99 -> System.exit(0);
                    default -> throw new CourseNotFoundException("Invalid input: " + option + ", please try again!");
                }
            }catch (InputMismatchException | CourseNotFoundException courseNotFoundException){
                System.out.println("=".repeat(160));
                if (courseNotFoundException.getMessage()==null){
                    System.out.println("Invalid input, please try again!");
                }else {
                    System.out.println(courseNotFoundException.getMessage());
                }
                System.out.println("=".repeat(160));
            }
        }
    }
}