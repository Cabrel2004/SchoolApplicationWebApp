package com.example.schoolstock.service;
import com.example.schoolstock.Model.Exam;
import com.example.schoolstock.repo.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {
    private final ExamRepo examRepo;

    @Autowired
    public ExamService(ExamRepo examRepo) {
        this.examRepo = examRepo;
    }

    public List<Exam> getAllExams() {
        return examRepo.findAll();
    }

    public Optional<Exam> getExamById(String id) {
        return examRepo.findById(id);
    }

    public Exam createExam(Exam exam) {
        return examRepo.save(exam);
    }

    public Exam updateExam(String id, Exam exam) {
        Optional<Exam> existingExam = examRepo.findById(id);
        if (existingExam.isPresent()) {
            exam.setId(id);
            return examRepo.save(exam);
        }
        return null; 
    }

    public void deleteExam(String id) {
        examRepo.deleteById(id);
    }
}