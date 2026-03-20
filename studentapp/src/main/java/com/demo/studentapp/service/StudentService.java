    package com.demo.studentapp.service; 
    
    import com.demo.studentapp.model.Student; 
    import com.demo.studentapp.repository.StudentRepository; 
    import org.springframework.beans.factory.annotation.Autowired; 
    import org.springframework.stereotype.Service; 
    
    import java.util.List; 
    
    @Service 
    public class StudentService { 
    
    @Autowired 
    private StudentRepository repo; 
    
    public Student saveStudent(Student s) { 
        return repo.save(s); 
    } 
    
    public List<Student> getAllStudents() { 
        return repo.findAll(); 
    } 
    
    public Student getStudentById(int id) { 
        return repo.findById(id).orElse(null); 
    } 
    
    public void deleteStudent(int id) { 
        repo.deleteById(id); 
    } 
    } 