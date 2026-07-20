package com.Manudeep.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateStudentResponseDTO {
    private int id;
    private String name;
    private String department;
    private  int age;
}
