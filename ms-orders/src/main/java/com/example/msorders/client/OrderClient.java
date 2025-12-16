package com.example.msorders.client;


import com.example.msorders.dto.OrderRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient (name = "ms-orderOp", url = "http://localhost:4545")
public interface OrderClient {

    @PostMapping ("/payments/get")
    Boolean getOrder(@RequestBody OrderRequestDto orderRequestDto);
}

