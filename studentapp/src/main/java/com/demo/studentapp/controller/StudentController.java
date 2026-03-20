    package com.demo.studentapp.controller; 
    
    import com.demo.studentapp.model.Student; 
    import com.demo.studentapp.service.StudentService; 
    import org.springframework.beans.factory.annotation.Autowired; 
    import org.springframework.web.bind.annotation.*; 
    
    import java.util.List; 
    
    @RestController 
    @RequestMapping("/students") 
    public class StudentController { 
    
    @Autowired 
    private StudentService service; 
    
    @PostMapping 
    public Student addStudent(@RequestBody Student s) { 
        return service.saveStudent(s); 
    } 
    
    @GetMapping 
    public List<Student> getAll() { 
        return service.getAllStudents(); 
    } 
    
    @GetMapping("/{id}") 
    public Student getById(@PathVariable int id) { 
        return service.getStudentById(id); 
    } 
    
    @DeleteMapping("/{id}") 
    public String delete(@PathVariable int id) { 
        service.deleteStudent(id); 
        return "Deleted successfully"; 
    } 
    } 