package com.example.mscourse.Mapper;

import com.example.mscourse.Dto.CourseRequestDto;
import com.example.mscourse.Entity.CourseEntity;

import java.time.LocalDateTime;

public class MapperDtoToCourseEntity {
    public static CourseEntity courseEntity (CourseRequestDto courseRequestDto) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(courseRequestDto.getName());
        courseEntity.setTeacherName(courseRequestDto.getTeacherName());
        courseEntity.setCoursePrice(courseRequestDto.getCoursePrice());
        courseEntity.setTeacherSalary(courseRequestDto.getTeacherSalary());
        courseEntity.setCreatedAt(LocalDateTime.now());
        courseEntity.setUpdatedAt(LocalDateTime.now());
     return courseEntity;
    }
}
