package com.example.SpringBoot;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class EnrollmentController {

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentController() {

        students.add(new Student(1, "Rahul"));
        students.add(new Student(2, "Priya"));

        courses.add(new Course(1, "Java"));
        courses.add(new Course(2, "Spring Boot"));

        enrollments.add(new Enrollment(1, 1, 1));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping("/enrollments")
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        courses.add(course);
        return course;
    }

    @PostMapping("/enroll")
    public Enrollment enrollStudent(@RequestBody Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

}