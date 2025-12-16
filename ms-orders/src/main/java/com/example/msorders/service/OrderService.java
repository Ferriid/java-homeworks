package com.example.msorders.service;
import com.example.msorders.OrderUnique;
import com.example.msorders.client.OrderClient;
import com.example.msorders.dto.OrderRequestDto;
import com.example.msorders.entity.OrderEntity;
import com.example.msorders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderUnique orderUnique;
    private final OrderClient orderClient;

     public Boolean sendRequestForCashMoney (OrderRequestDto orderRequestDto) {
        var orderEntity = new OrderEntity();
        orderEntity.setCustomerId(orderRequestDto.getCustomerId());
        orderEntity.setAmount(orderRequestDto.getAmount());
        orderEntity.setPan(orderRequestDto.getPan());
        orderEntity.setCurrency(orderRequestDto.getCurrency());
        orderEntity.setOrderNumber(orderUnique.generateUniqueOrderId());
        orderEntity.setCreatedAt(LocalDateTime.now());
        orderRepository.save(orderEntity);
        var result = orderClient.getOrder(orderRequestDto);
        if (result==true){
            orderEntity.setStatus("DONE");
            orderRepository.save(orderEntity);
        }
        return    orderClient.getOrder(orderRequestDto);

     }

}
