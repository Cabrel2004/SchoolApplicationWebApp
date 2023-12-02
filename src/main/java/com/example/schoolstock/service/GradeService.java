package com.example.schoolstock.service;

import com.example.schoolstock.Model.Grade;
import com.example.schoolstock.repo.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
    public static GradeRepo gradeRepo;

    @Autowired
    public GradeService(GradeRepo gradeRepo){
        this.gradeRepo=gradeRepo;
    }
    public static Grade CalculateGrade(int value){
        Grade grade = new Grade();
        grade.setValue(String.valueOf(value));

        if (value >= 90) {
            grade.setCategory("Distinction");
        } else if (value >= 80) {
            grade.setCategory("Excellent");
        } else if (value >= 70) {
            grade.setCategory("Good");
        } else {
            grade.setCategory("Average or below");
        }

        return gradeRepo.save(grade);

    }
}
