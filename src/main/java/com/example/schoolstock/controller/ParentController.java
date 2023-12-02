package com.example.schoolstock.controller;

import com.example.schoolstock.Model.Parent;
import com.example.schoolstock.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1parents")

public class ParentController {
    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping("create-parents")
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        Parent createdParent = parentService.createParent(parent);
        return ResponseEntity.ok(createdParent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable String id) {
        Parent parent = parentService.getParentById(id);
        if (parent != null) {
            return ResponseEntity.ok(parent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("All-parents")
    public ResponseEntity<List<Parent>> getAllParents() {
        List<Parent> parents = parentService.getAllParents();
        return ResponseEntity.ok(parents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable String id, @RequestBody Parent parent) {
        Parent existingParent = parentService.getParentById(id);
        if (existingParent != null) {
            parent.setId(id);
            Parent updatedParent = parentService.updateParent(parent);
            return ResponseEntity.ok(updatedParent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable String id) {
        Parent existingParent = parentService.getParentById(id);
        if (existingParent != null) {
            parentService.deleteParent(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}