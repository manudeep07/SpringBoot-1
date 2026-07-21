package com.Manudeep.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CreateStudentResponseDTO {
    private int id;
    private String name;
    private String email;
    private String department;
    private  int age;

}
