package com.example.schoolstock.service;
import com.example.schoolstock.Model.Assessment;
import com.example.schoolstock.repo.AssessmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {
    private final AssessmentRepo assessmentRepo;

    @Autowired
    public AssessmentService(AssessmentRepo assessmentRepo) {
        this.assessmentRepo = assessmentRepo;
    }

    public List<Assessment> getAllAssessments() {
        return assessmentRepo.findAll();
    }

    public Optional<Assessment> getAssessmentById(String id) {
        return assessmentRepo.findById(id);
    }

    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepo.save(assessment);
    }

    public Assessment updateAssessment(String id, Assessment assessment) {
        assessment.setId(id);
        return assessmentRepo.save(assessment);
    }

    public void deleteAssessment(String id) {
        assessmentRepo.deleteById(id);
    }
}