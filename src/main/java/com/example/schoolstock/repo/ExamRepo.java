package com.example.schoolstock.repo;

import com.example.schoolstock.Model.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamRepo extends MongoRepository<Exam,String> {
}
