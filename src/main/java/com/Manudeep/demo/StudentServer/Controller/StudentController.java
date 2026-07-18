package com.Manudeep.demo.StudentServer.Controller;
import com.Manudeep.demo.StudentServer.Entity.Student;
import com.Manudeep.demo.StudentServer.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudentByID(@PathVariable int id){
        Student student = studentService.getStudentByid(id);
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.status(200).body(students);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable Integer id,
            @RequestBody Student student){

        Student updatedStudent = studentService.updateStudent(id, student);

        if(updatedStudent == null){
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id){
        String msg = studentService.deleteStudentByid(id);
        return ResponseEntity.status(200).body(msg);
    }
    // 3. update the student information

    // 4. delete the student information
}