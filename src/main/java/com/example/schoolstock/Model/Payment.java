package com.example.schoolstock.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "payments")
public class Payment {
    public String studentName;
    @Id
    public String id;
    public int gradeLevel;
    public double tuitionFee;
    public double amountPaid;
    public double remainingBalance;
}
