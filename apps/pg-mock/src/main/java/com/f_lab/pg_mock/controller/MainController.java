package com.f_lab.pg_mock.controller;

import com.f_lab.pg_mock.dto.PaymentsConfirmReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final Random random = new Random();

    @PostMapping("/v1/payments/confirm")
    public ResponseEntity<?> paymentsConfirm(@RequestBody PaymentsConfirmReqDto _reqDto) {
        if (random.nextInt(100) < 1) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok().build();
    }
}
