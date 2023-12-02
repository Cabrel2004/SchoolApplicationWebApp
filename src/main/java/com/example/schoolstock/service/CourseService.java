package com.example.schoolstock.service;

import com.example.schoolstock.Model.Course;
import com.example.schoolstock.coursedto.CreateCourseDto;
import com.example.schoolstock.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    @Autowired
    private final CourseRepo courseRepo;

    public Course findById(String id) {
        return courseRepo.findById(id).orElse(null);
    }


    public Course CreateCourse(CreateCourseDto dto) {
        try {
            var course= findById(dto.getId());
            if (course==null){
                course=new Course();
                course.setId(dto.getId());
                course.setName(dto.getName());
                return courseRepo.save(course);
            }
            else {
                throw new RuntimeException("The course has been successfully created" + dto.getId() + "The course does not exist");
            }

        }catch (Exception e){
            throw new RuntimeException("course not found");
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses=courseRepo.findAll();
        if (courses.isEmpty()){
            throw new RuntimeException("course not found");
        }
        return courses;
    }

    public void deleteId(String id) {
        courseRepo.deleteById(id);
    }
}
