package com.example.schoolstock.controller;

import com.example.schoolstock.Model.Payment;
import com.example.schoolstock.PaymentDto.CreatePaymentDto;
import com.example.schoolstock.PaymentDto.UpdatePaymentDto;
import com.example.schoolstock.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/payments")
public class PaymentController {

    @Autowired
    private final PaymentService paymentService;

    @GetMapping("All-Payments")
    public List<Payment> getAllPayment(){
     List <Payment> Payments= paymentService.getAllPayment();
     if (Payments.isEmpty()){
         throw new RuntimeException("No payment were found");
     }
     return Payments;
    }

    @GetMapping("Payment{id}")
    public Payment getPaymentById(@RequestParam String id){
        return paymentService.getById(id);
    }

    @PostMapping("create-payments")
    public ResponseEntity<Payment> CreatePayment(@RequestBody CreatePaymentDto dto){
        try {
            Payment existingPayment = paymentService.findPaymentById(dto.getId());
            if (existingPayment!=null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            Payment savedPayment=paymentService.CreatePayment(dto);
            if (savedPayment!=null){
                return ResponseEntity.ok(savedPayment);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("Update-Payments")
    public ResponseEntity<Payment> UpdatePayment(@RequestBody UpdatePaymentDto dto){
        Payment Updatepayments=paymentService.UpdatePayment(dto);
        if (Updatepayments!=null){
            return ResponseEntity.ok(Updatepayments);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("delete-by-id")
    public void deleteById(@RequestParam String id){
        paymentService.deleteById(id);
    }
}
