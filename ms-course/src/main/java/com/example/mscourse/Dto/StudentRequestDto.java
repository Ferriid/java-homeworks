package com.example.mscourse.Dto;

import com.example.mscourse.Enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentRequestDto {
    private String studentId;
    private String name;
    private String course;
    private Integer age;
    private PaymentStatus paymentStatus;
    private String email;
}
