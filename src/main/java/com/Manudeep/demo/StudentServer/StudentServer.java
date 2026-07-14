package com.Manudeep.demo.StudentServer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {
    // 1. Store the Student
    @PostMapping("/create")
    public String storeStudent(){
        return """
                id:1
                name: "Manudeep"
                Department : CSE
                age: 20
                """;
    }

    // 2. read the Student with id


    // 3. update the student information

    // 4. delete the student information
}
