package com.Manudeep.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentRequestDTO {
    private String name;
    private String department;
    private String email;
    private  int age;
}
