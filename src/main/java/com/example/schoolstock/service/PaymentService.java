package com.example.schoolstock.service;

import com.example.schoolstock.Model.Payment;
import com.example.schoolstock.PaymentDto.CreatePaymentDto;
import com.example.schoolstock.PaymentDto.UpdatePaymentDto;
import com.example.schoolstock.repo.PaymentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Autowired
    private final PaymentRepo paymentRepo;


    public List<Payment> getAllPayment() {
        List<Payment> payments = paymentRepo.findAll();
        if (payments.isEmpty()) {
            throw new RuntimeException("No payments were found");
        }
        return payments;
    }

    public Payment getById(String id) {
        return paymentRepo.findById(id).orElse(null);
    }

    public Payment CreatePayment(CreatePaymentDto dto) {
        try {
            var Payments = findPaymentById(dto.getId());
            if (Payments == null) {
                Payments = new Payment();
                Payments.setId(dto.getId());
                Payments.setAmountPaid(dto.getAmountPaid());
                Payments.setGradeLevel(dto.getGradeLevel());
                Payments.setRemainingBalance(dto.getRemainingBalance());
                Payments.setTuitionFee(dto.getTuitionFee());
                Payments.setStudentName(dto.getStudentName());
                return paymentRepo.save(Payments);
            } else {
                throw new RuntimeException("The payment with id  exist" + dto.getId() + "The payment with id  does not exist");
            }

        } catch (Exception e) {
            throw new RuntimeException("An error occured when creating the payment", e);
        }

    }


    public Payment findPaymentById(String id) {
        return paymentRepo.findById(id).orElse(null);
    }

    public Payment UpdatePayment(UpdatePaymentDto dto) {
        try {
            var payments = findPaymentById(dto.getId());
            if (payments != null) {
                payments.setStudentName(dto.getStudentName());
                payments.setAmountPaid(dto.getAmountPaid());
                payments.setTuitionFee(dto.getTuitionFee());
                payments.setGradeLevel(dto.getGradeLevel());
                payments.setRemainingBalance(dto.getRemainingBalance());
                  return paymentRepo.save(payments);
            } else {
                throw new RuntimeException("The payment with id exist" + dto.getId() + "The payment does not exist");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    public void deleteById(String id) {
        paymentRepo.deleteById(id);
    }
}

