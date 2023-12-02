package com.example.schoolstock.repo;

import com.example.schoolstock.Model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepo extends MongoRepository<Course,String> {
}
