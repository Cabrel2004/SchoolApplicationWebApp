package com.example.schoolstock.repo;

import com.example.schoolstock.Model.Grade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GradeRepo extends MongoRepository<Grade,String> {
}
