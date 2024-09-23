package com.f_lab.java_commerce.service;

import com.f_lab.java_commerce.api.external.PgApi;
import com.f_lab.java_commerce.dto.ConfirmPaymentReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final OrderService orderService;
    private final PgApi pgApi;

    public void confirmPayment(ConfirmPaymentReqDto dto) {
        validatePayment();
        pgApi.confirmPayment(dto.paymentKey(), dto.orderId(), dto.amount());
    }

    private void validatePayment() {
        // Payment validation logic
    }
}
