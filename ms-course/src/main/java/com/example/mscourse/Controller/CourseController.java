package com.example.mscourse.Controller;


import com.example.mscourse.Dto.CourseRequestDto;
import com.example.mscourse.Dto.CourseResponseDto;
import com.example.mscourse.Dto.StudentRequestDto;
import com.example.mscourse.Service.CourseService;
import com.example.mscourse.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private final StudentService studentService;

    @GetMapping("/all")
    public List<CourseResponseDto> findAllCourseEntities() {
        return courseService.getAllCourseInfo();
    }
    @GetMapping
    public CourseResponseDto findCourseEntityByCourseName(@RequestParam String courseName) {
        return courseService.getCourseInfoByName(courseName);
    }

    @PostMapping("/addcourse")
    public void addCourse(@RequestBody CourseRequestDto courseRequestDto) {
        courseService.addCourse(courseRequestDto);
    }
//    @PostMapping("/addstudent")
//    public void addStudentToTheCourse (@RequestBody StudentRequestDto studentRequestDto){
//
//        studentService.addStudentToTheCourse(studentRequestDto);
//    }


}
