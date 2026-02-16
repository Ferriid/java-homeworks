package com.example.mscourse.Mapper;

import com.example.mscourse.Dto.StudentRequestDto;
import com.example.mscourse.Entity.CourseEntity;
import com.example.mscourse.Entity.StudentEntity;

import java.util.Locale;
import java.util.UUID;

public class MapperDtoToStudentEntity {
    public static StudentEntity student (StudentRequestDto studentRequestDto, CourseEntity course){
        StudentEntity student = new StudentEntity();
        student.setStudentId(UUID.randomUUID().toString().replace("-", "").substring(0, 7).toUpperCase(Locale.ROOT));
        student.setName(studentRequestDto.getName());
        student.setCourseId(studentRequestDto.getCourseId());
        student.setCourse(course.getName());
        student.setTeacherName(course.getTeacherName());
        student.setAge(studentRequestDto.getAge());
        student.setEmail(studentRequestDto.getEmail());
        return student;
    }
}
