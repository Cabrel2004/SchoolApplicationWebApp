package com.example.schoolstock.service;
import com.example.schoolstock.Model.Parent;
import com.example.schoolstock.repo.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    private final ParentRepo parentRepo;

    @Autowired
    public ParentService(ParentRepo parentRepo) {
        this.parentRepo = parentRepo;
    }

    public Parent createParent(Parent parent) {
        return parentRepo.save(parent);
    }

    public Parent getParentById(String id) {
        return parentRepo.findById(id).orElse(null);
    }

    public List<Parent> getAllParents() {
        return parentRepo.findAll();
    }

    public Parent updateParent(Parent parent) {
        return parentRepo.save(parent);
    }

    public void deleteParent(String id) {
        parentRepo.deleteById(id);
    }
}