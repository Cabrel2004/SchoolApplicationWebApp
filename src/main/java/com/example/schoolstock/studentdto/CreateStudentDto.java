package com.example.schoolstock.studentdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentDto {
    @Id
    private String id;
    private String name;
    private String email;
    private LocalDate dob;
}
