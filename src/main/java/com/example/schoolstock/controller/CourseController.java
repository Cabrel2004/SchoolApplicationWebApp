package com.example.schoolstock.controller;

import com.example.schoolstock.Model.Course;
import com.example.schoolstock.coursedto.CreateCourseDto;
import com.example.schoolstock.coursedto.UpdateCourseDto;
import com.example.schoolstock.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/courses")
public class CourseController {
    @Autowired
    private final CourseService courseService;

    @GetMapping("find-by-id")
    public Course findById(@RequestParam String id){
        return courseService.findById(id);
    }

    @PostMapping("create-courses")
    public ResponseEntity<Course> CreateCourse(@RequestBody CreateCourseDto dto){
        try {
            Course existingCourses= courseService.findById(dto.getId());
            if (existingCourses!=null){

                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            }
            Course savedCourse=courseService.CreateCourse(dto);
            if (savedCourse!=null){
                return ResponseEntity.ok(savedCourse);
            }

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }catch (Exception e){
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("All-courses")
    public List<Course> getAllCourses(){
        List<Course> Courses=courseService.getAllCourses();
        if (Courses.isEmpty()){
            throw new RuntimeException("The course is not found");
        }
        return Courses;
    }

    @PutMapping("update-courses")
    public ResponseEntity<Course> UpdateCourse(UpdateCourseDto dto){
         Course updatecourse = courseService.findById(dto.getId());
         if (updatecourse != null) {
             return ResponseEntity.ok(updatecourse);
         } else {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         }
     }

     @DeleteMapping("delete-courses")
    public void deleteById(@RequestParam String id){
        courseService.deleteId(id);
     }
}




