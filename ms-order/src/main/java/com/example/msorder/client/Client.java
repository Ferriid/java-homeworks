package com.example.msorder.client;

import com.example.msorder.dto.OrderRequestDto;
import com.example.msorder.entity.OrderEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient (name = "cardOrder", url = "http:localhost:8586/cardorder")
public interface Client {
    @GetMapping
    OrderEntity order (@RequestParam String cardnumber, @RequestParam double amount);



}
