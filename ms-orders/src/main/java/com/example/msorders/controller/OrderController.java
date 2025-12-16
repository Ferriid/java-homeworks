package com.example.msorders.controller;


import com.example.msorders.dto.OrderRequestDto;
import com.example.msorders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/getinfo")
    public Boolean sendRequestForPayment (@RequestBody OrderRequestDto orderRequestDto) {
return orderService.sendRequestForCashMoney(orderRequestDto);
    }
    @GetMapping("/get")
    public String getOrder() {
        return "getOrder";
    }
}
