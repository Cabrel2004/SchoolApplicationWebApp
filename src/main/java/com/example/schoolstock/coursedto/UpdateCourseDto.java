package com.example.schoolstock.coursedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCourseDto {
    @Id
    private String id;
    private String name;
}
