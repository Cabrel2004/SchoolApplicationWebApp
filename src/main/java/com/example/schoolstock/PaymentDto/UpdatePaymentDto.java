package com.example.schoolstock.PaymentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentDto {
    public String studentName;
    @Id
    public String id;
    public int gradeLevel;
    public double tuitionFee;
    public double amountPaid;
    public double remainingBalance;
}
