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

    public UpdateStudentResponseDTO updateStudent(Integer id, UpdateStudentRequestDTO updatedStudent) {

        Student existingStudent = studentRepository.findById(id).orElse(null);



        if (existingStudent == null) {
            return null;
        }

        UpdateStudentResponseDTO updatedStudentResponse = mapToUpdateStudentResponseDTO(existingStudent);
        if(updatedStudent.getName()!=null)
          existingStudent.setName(updatedStudent.getName());

        existingStudent.setAge(updatedStudent.getAge());
        studentRepository.save(existingStudent);
        return updatedStudentResponse;
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

        student.setName(createStudentRequestDTO.getName());
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

    private UpdateStudentResponseDTO mapToUpdateStudentResponseDTO(Student student){
        UpdateStudentResponseDTO updateStudentResponseDTO = new UpdateStudentResponseDTO();

        updateStudentResponseDTO.setName(student.getName());
        updateStudentResponseDTO.setAge(student.getAge());
        updateStudentResponseDTO.setId(student.getId());
        updateStudentResponseDTO.setDepartment(student.getDepartment());
        return updateStudentResponseDTO;
    }
}
