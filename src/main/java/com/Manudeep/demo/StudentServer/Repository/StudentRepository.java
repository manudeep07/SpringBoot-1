package com.Manudeep.demo.StudentServer.Repository;

import com.Manudeep.demo.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Integer> {
}
