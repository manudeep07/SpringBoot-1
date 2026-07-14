package com.Manudeep.demo.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    StudentService studentService;


    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    // 1. Store the Student
    @PostMapping("/create")
    public ResponseEntity<Student> storeStudent(@RequestBody Student student){
       Student result = studentService.studentValidate(student);

       if(result == null)
       {
           return ResponseEntity.status(400).body(result);
       }
        return ResponseEntity.status(201).body(result);
    }

    // 2. read the Student with id


    // 3. update the student information

    // 4. delete the student information
}