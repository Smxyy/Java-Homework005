package service;

import exception.CourseNotFoundException;
import model.Course;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import repository.CourseRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CourseServiceImp implements CourseService {
    @Override
    public String formatLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM d HH:mm:ss yyyy", Locale.ENGLISH);
        String dateTime = LocalDateTime.now().format(formatter);
        return dateTime;
    }
    @Override
    public void addNewCourse() {
        CourseRepository.addCourse();
    }
    @Override
    public List<Course> getAllCourses(){
        return CourseRepository.getAllCourses();
    }
    @Override
    public void listAllCourses() {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for(int i=0;i<5;i++){
            table.setColumnWidth(i,30,30);
        }
        System.out.println("=".repeat(160));
        if (!(CourseRepository.getAllCourses().isEmpty())) {
            table.addCell("Course ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Instructor", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Start Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            for (Course course: CourseRepository.getAllCourses()) {
                table.addCell(String.valueOf(course.getId()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course.getTitle(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getInstructorName()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getRequirement()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course.getStartDate(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());
        }else{
            System.out.println("[+] No Course !");;
        }
        System.out.println("=".repeat(160));
    }
    @Override
    public Course getCourseById(Integer id) throws CourseNotFoundException{
        Table table = new Table(5,BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for(int i=0;i<5;i++){
            table.setColumnWidth(i,30,30);
        }
        var courses = CourseRepository.getAllCourses().stream().filter(e -> e.getId().toString().equals(id.toString().trim())).toList();
        if(courses.isEmpty()) {
            throw new CourseNotFoundException("[!] Course not found with ID: " + id);
        }else{
            table.addCell("Course ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Instructor", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Start Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            for (Course course: courses) {
                table.addCell(String.valueOf(course.getId()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course.getTitle(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getInstructorName()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getRequirement()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course.getStartDate(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());
        }
        return courses.getFirst();
    }
    @Override
    public Course getCourseByTitle(String title) throws CourseNotFoundException{
        Table table = new Table(5,BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for(int i=0;i<5;i++){
            table.setColumnWidth(i,30,30);
        }
        var courses = CourseRepository.getAllCourses().stream().filter(e -> e.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
        if(courses.isEmpty()) {
            throw new CourseNotFoundException("[!] Course not found with title: " + title);
        }else{
            table.addCell("Course ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Instructor", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Start Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            for (Course course: courses) {
                table.addCell(String.valueOf(course.getId()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course.getTitle(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getInstructorName()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getRequirement()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course.getStartDate(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());
        }
        return courses.getFirst();
    }
    @Override
    public void removeCourseByID(Integer id) throws CourseNotFoundException{
        List<Course> courses = CourseRepository.getAllCourses();
        List<Course> removeCourse = courses.stream().filter(a->a.getId().toString().equals(id.toString().trim())).toList();
        courses.removeAll(removeCourse);
        if (!(removeCourse.isEmpty())) {
            System.out.println("[+] Removed course with " + id + " successfully!");
        }else {
            throw new CourseNotFoundException("[!] Course not found with ID: " + id);
        }
    }
}
