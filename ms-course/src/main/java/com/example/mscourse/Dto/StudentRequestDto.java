package com.example.mscourse.Dto;

import com.example.mscourse.Enums.PaymentStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentRequestDto {

    @Size(min = 7, max = 7 , message = "id must be 7 symbols" )
    private String studentId;

    @Size(min = 5, max = 5 , message = "id must be 5 symbols" )
    private String courseId;
    private String name;
    @Min(7)
    @Max(90)
    private Integer age;
    private PaymentStatus paymentStatus;

    @Email(message = "not correct email")
    private String email;
}
