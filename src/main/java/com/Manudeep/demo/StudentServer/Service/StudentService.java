package com.Manudeep.demo.StudentServer.Service;

import com.Manudeep.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.Manudeep.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.Manudeep.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.Manudeep.demo.StudentServer.DTO.UpdateStudentResponseDTO;
import com.Manudeep.demo.StudentServer.Entity.Student;
import com.Manudeep.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {
        Student student = mapToStudent(createStudentRequestDTO);

        student = studentRepository.save(student);
        CreateStudentResponseDTO createStudentResponseDTO = mapToStudentResponseDTO(student);
        return createStudentResponseDTO;
    }

    public Student getStudentByid(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public UpdateStudentResponseDTO updateStudent(Integer id, UpdateStudentRequestDTO updatedStudent) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());

        UpdateStudentResponseDTO updatedStudentResponse = mapToUpdateStudentResponseDTO(existingStudent);
        studentRepository.save(existingStudent);
        return updatedStudentResponse;
    }

    public String deleteStudentByid(int id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.deleteById(id);
        return "deleted";
    }

    public List<Student> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    private Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO){
        Student student = new Student();
        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private CreateStudentResponseDTO mapToStudentResponseDTO(Student student){
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();
//        System.out.println(student.getId());
        createStudentResponseDTO.setId(student.getId());

        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDepartment());
        return createStudentResponseDTO;
    }

    private UpdateStudentResponseDTO mapToUpdateStudentResponseDTO(Student student){
        UpdateStudentResponseDTO updateStudentResponseDTO = new UpdateStudentResponseDTO();

        updateStudentResponseDTO.setName(student.getName());
        updateStudentResponseDTO.setAge(student.getAge());
        updateStudentResponseDTO.setId(student.getId());
        updateStudentResponseDTO.setDepartment(student.getDepartment());
        return updateStudentResponseDTO;
    }
}
