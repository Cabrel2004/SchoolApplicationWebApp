package com.example.schoolstock.controller;

import com.example.schoolstock.Model.StudentModel;
import com.example.schoolstock.service.StudentService;
import com.example.schoolstock.studentdto.CreateStudentDto;
import com.example.schoolstock.studentdto.UpdateStudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    @GetMapping("All-students")
    public List<StudentModel> getAllStudents(){
        List<StudentModel> Student= studentService.getAllStudents();
        if (Student.isEmpty()){
            throw new RuntimeException("No students were found");
        }
        return Student;
    }

    @GetMapping("students{id}")
    public StudentModel getStudentbyId(@RequestParam String id){
        return studentService.getbyId(id);
    }

    @PostMapping("create-students")
    public ResponseEntity<StudentModel> CreateStudent(@RequestBody CreateStudentDto dto){
        try {
            StudentModel existingStudent=studentService.findstudentById(dto.getId());
            if (existingStudent!=null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            StudentModel savedStudent=studentService.CreateStudent(dto);
            if (savedStudent!=null){
                return ResponseEntity.ok(savedStudent);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("update-students")
    public ResponseEntity<StudentModel> UpdateStudent(@RequestBody UpdateStudentDto dto){
            StudentModel UpdatedStudent=studentService.UpdateStudent(dto);
              if (UpdatedStudent!=null){
                  return ResponseEntity.ok(UpdatedStudent);
              }
              else{
                  return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
              }
    }

    @DeleteMapping("student{id}")
    public void deletestudentbyId(@RequestParam String id){
         studentService.deletebyId(id);
    }
}
