package com.example.schoolstock.repo;

import com.example.schoolstock.Model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepo extends MongoRepository<Teacher,String> {

}