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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseResponseDto> getAllCourseInfo() {
        return courseRepository.findAll()
                .stream()
                .map(c -> new CourseResponseDto(
                        c.getCourseId(),
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
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(UUID.randomUUID().toString().replace("-", "").substring(0, 5).toUpperCase(Locale.ROOT));
        courseEntity.setCreatedAt(LocalDateTime.now());
        courseEntity.setUpdatedAt(LocalDateTime.now());
        courseRepository.save(MapperDtoToCourseEntity.mapDtoToCourseEntity(courseRequestDto, courseEntity));

    }

    public void updateCourse (CourseRequestDto courseRequestDto, String id) {
        var course = courseRepository.findCourseEntityByCourseId(id).orElseThrow(()-> new CourseNotFoundException("Course not found"));
        courseRepository.save(MapperDtoToCourseEntity.mapDtoToCourseEntity(courseRequestDto, course));
        course.setUpdatedAt(LocalDateTime.now());
        courseRepository.save(course);
    }

    public void deleteCourse (String name) {}
    public CourseEntity courseExistence (String name) {
        return courseRepository.findCourseEntityByName(name).orElseThrow(() ->
             new CourseNotFoundException("Course not found.."));
        }

    }
