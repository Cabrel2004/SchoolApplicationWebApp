package com.example.schoolstock.repo;

import com.example.schoolstock.Model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepo extends MongoRepository<StudentModel,String> {
    Optional<StudentModel> findByEmail(String email);

}
