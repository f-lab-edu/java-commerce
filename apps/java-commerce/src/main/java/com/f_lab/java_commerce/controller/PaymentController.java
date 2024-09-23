package com.f_lab.java_commerce.controller;

import com.f_lab.java_commerce.dto.ConfirmPaymentReqDto;
import com.f_lab.java_commerce.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payments/confirm")
    public ResponseEntity<?> confirmPayment(@RequestBody ConfirmPaymentReqDto dto) {
        paymentService.confirmPayment(dto);

        return ResponseEntity.ok().build();
    }
}
