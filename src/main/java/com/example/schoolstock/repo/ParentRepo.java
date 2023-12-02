package com.example.schoolstock.repo;

import com.example.schoolstock.Model.Parent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParentRepo extends MongoRepository<Parent, String> {

}