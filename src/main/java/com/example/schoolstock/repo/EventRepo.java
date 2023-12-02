package com.example.schoolstock.repo;

import com.example.schoolstock.Model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EventRepo extends MongoRepository<Event,String> {

}
