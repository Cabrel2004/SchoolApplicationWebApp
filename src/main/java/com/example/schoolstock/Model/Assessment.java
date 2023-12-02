package com.example.schoolstock.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "assessments")
public class Assessment {
    @Id
    private String id;
    private String examId;
    private String studentId;
    private int score;

}
