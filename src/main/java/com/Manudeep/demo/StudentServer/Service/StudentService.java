package com.Manudeep.demo.StudentServer.Service;

import com.Manudeep.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.Manudeep.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.Manudeep.demo.StudentServer.Entity.Student;
import com.Manudeep.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {
        Student student = mapToStudent(createStudentRequestDTO);

        CreateStudentResponseDTO createStudentResponseDTO = mapToStudentResponseDTO(student);
        studentRepository.save(student);
        return createStudentResponseDTO;
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

    public List<Student> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    private Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO){
        Student student = new Student();

        student.setName((createStudentRequestDTO.getName()));
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private CreateStudentResponseDTO mapToStudentResponseDTO(Student student){
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();
        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDepartment());
        return createStudentResponseDTO;
    }
}
