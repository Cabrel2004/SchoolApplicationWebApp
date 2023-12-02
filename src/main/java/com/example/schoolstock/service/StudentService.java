package com.example.schoolstock.service;

import com.example.schoolstock.repo.StudentRepo;
import com.example.schoolstock.Model.StudentModel;
import com.example.schoolstock.studentdto.CreateStudentDto;
import com.example.schoolstock.studentdto.UpdateStudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    @Autowired
    private  final StudentRepo studentRepo;

    public List<StudentModel> getAllStudents() {
        List<StudentModel> Student= studentRepo.findAll();
        if (Student.isEmpty()){
            throw new RuntimeException("No students were found");
        }
        return Student;
    }

    public StudentModel getbyId(String id) {
        return studentRepo.findById(id).orElse(null);
    }

    public StudentModel CreateStudent(CreateStudentDto dto) {
        try {
            var students= findstudentById(dto.getId());
            if (students==null){
                students=new StudentModel();
                students.setId(dto.getId());
                students.setDob(dto.getDob());
                students.setEmail(dto.getEmail());
                students.setName(dto.getName());
                return studentRepo.save(students);
            }
            else {
                throw new RuntimeException("The student id exist" + dto.getId()+ "does not exist");
            }

        }catch (Exception e){
            throw new RuntimeException("An error occured when creating the student" ,e);
        }
    }

    public StudentModel findstudentById(String id) {
        return studentRepo.findById(id).orElse(null);
    }

    public StudentModel UpdateStudent(UpdateStudentDto dto) {
        try {
            var Student = findstudentById(dto.getId());
            if (Student != null) {
                Student.setDob(dto.getDob());
                Student.setEmail(dto.getEmail());
                Student.setName(dto.getName());

                return studentRepo.save(Student);

            } else {
                throw new RuntimeException("Whitelisting with id " + dto.getId() + " does not exist");
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void deletebyId(String id) {
         studentRepo.deleteById(id);
    }
}
