package com.example.mscourse.Dto;

import com.example.mscourse.Enums.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {
    private String studentId;
    private String name;
    private String courseId;
    private String course;
    private String teacherName;
    private Integer age;
    private PaymentStatus paymentStatus;
    private String email;
    private LocalDateTime educationStarted;
}
