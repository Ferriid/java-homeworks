package com.example.mscourse.Mapper;

import com.example.mscourse.Dto.CourseRequestDto;
import com.example.mscourse.Entity.CourseEntity;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

public class MapperDtoToCourseEntity {
    public static CourseEntity mapDtoToCourseEntity(CourseRequestDto courseRequestDto, CourseEntity courseEntity) {
        courseEntity.setName(courseRequestDto.getName());
        courseEntity.setTeacherName(courseRequestDto.getTeacherName());
        courseEntity.setCoursePrice(courseRequestDto.getCoursePrice());
        courseEntity.setTeacherSalary(courseRequestDto.getTeacherSalary());
     return courseEntity;
    }
}
