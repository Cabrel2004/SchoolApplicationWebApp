package com.example.schoolstock.repo;

import com.example.schoolstock.Model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepo extends MongoRepository<Payment,String> {
}
