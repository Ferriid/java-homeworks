package com.example.mscourse.Service;


import com.example.mscourse.Dto.CourseRequestDto;
import com.example.mscourse.Dto.CourseResponseDto;
import com.example.mscourse.Entity.CourseEntity;
import com.example.mscourse.Exception.CourseNotFoundException;
import com.example.mscourse.Mapper.MapperDtoToCourseEntity;
import com.example.mscourse.Mapper.MappertCourseEntityToResponse;
import com.example.mscourse.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseResponseDto> getAllCourseInfo() {
        return courseRepository.findAll()
                .stream()
                .map(c -> new CourseResponseDto(
                        c.getName(),
                        c.getTeacherName(),
                        c.getEnrollment(),
                        c.getCoursePrice()
                ))
                .toList();
    }

    public CourseResponseDto getCourseInfoByName (String name) {
return MappertCourseEntityToResponse.mapEntityToResponse(courseExistence(name));
//        return MappertEntityToResponse.mapEntityToResponse(courseRepository.findCourseEntityByName(name).orElseThrow(() ->
//                new CourseNotFoundException("Course not found..")));
    }

    public CourseResponseDto getCourseById (Long id) {
        return courseRepository.findCourseEntityById(id);
    }

    public void addCourse (CourseRequestDto courseRequestDto) {
        courseRepository.save(MapperDtoToCourseEntity.courseEntity(courseRequestDto));
    }

    public void updateCourse (CourseRequestDto courseRequestDto) {}

    public void deleteCourse (String name) {

    }
    public CourseEntity courseExistence (String name) {
        return courseRepository.findCourseEntityByName(name).orElseThrow(() ->
             new CourseNotFoundException("Course not found.."));
        }



}
