package com.Manudeep.demo.StudentServer.Service;

import com.Manudeep.demo.StudentServer.Entity.Student;
import com.Manudeep.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student studentValidate(Student student) {
        int id = student.getId();
        String name = student.getName();
        int age = student.getAge();
        String department = student.getDepartment();

        if (id < 0 || name == null || age < 0 || department == null) {
            return null;
        }

        studentRepository.save(student);
        return student;
    }

    public Student getStudentByid(Integer id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student;
    }

    public Student updateStudent(Integer id, Student updatedStudent) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setDepartment(updatedStudent.getDepartment());

        return studentRepository.save(existingStudent);
    }

    public String deleteStudentByid(int id) {
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null){
            return null;
        }
        studentRepository.deleteById(id);
        return "deleted";
    }
}
