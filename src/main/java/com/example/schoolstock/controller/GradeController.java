package com.example.schoolstock.controller;

import com.example.schoolstock.Model.Grade;
import com.example.schoolstock.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/grades")
public class GradeController {
    public GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }
@PostMapping("Enter-Grades")
    public Grade SaveandCalculateGrades(@RequestParam("value")int value){
      return GradeService.CalculateGrade(value);
}
}
