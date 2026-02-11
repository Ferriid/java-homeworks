package com.example.mscourse.Mapper;

import com.example.mscourse.Dto.CourseResponseDto;
import com.example.mscourse.Entity.CourseEntity;

public class MappertCourseEntityToResponse {
    public static CourseResponseDto mapEntityToResponse (CourseEntity courseEntity){
        CourseResponseDto courseResponseDto = new CourseResponseDto();
        courseResponseDto.setName(courseEntity.getName());
        courseResponseDto.setTeacherName(courseEntity.getTeacherName());
        courseResponseDto.setEnrollment(courseEntity.getEnrollment());
        courseResponseDto.setCoursePrice(courseEntity.getCoursePrice());
        return courseResponseDto;
    }
}
