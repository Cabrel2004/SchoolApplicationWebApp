package com.example.schoolstock.eventdtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEventDto {
    @Id
    private String id;
    private String name;
    private LocalDateTime date;
}
