package com.example.schoolstock.repo;

import com.example.schoolstock.Model.Assessment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssessmentRepo extends MongoRepository<Assessment,String> {
}
