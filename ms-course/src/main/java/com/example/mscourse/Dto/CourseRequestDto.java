package com.example.mscourse.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDto {
    private String courseId;
    private String name;
    private String teacherName;
    private Integer enrollment;
    private Double coursePrice;
    private Double teacherSalary;

}
