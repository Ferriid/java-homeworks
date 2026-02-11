package com.example.mscourse.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {
    private String name;
    private String teacherName;
    private Integer enrollment;
    private Double coursePrice;
}
