package com.example.mscourse.Service;

import com.example.mscourse.Dto.StudentRequestDto;
import com.example.mscourse.Entity.StudentEntity;
import com.example.mscourse.Exception.CourseNotFoundException;
import com.example.mscourse.Exception.StudentNotFoundException;
import com.example.mscourse.Mapper.MapperDtoToStudentEntity;
import com.example.mscourse.Repository.CourseRepository;
import com.example.mscourse.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
private final CourseRepository courseRepository;
    public List<StudentEntity> findAll(){
       return studentRepository.findAll();
    }

    public StudentEntity findByStudentId (String id){
       return studentRepository.findByStudentId(id)
               .orElseThrow(()->new StudentNotFoundException("Student not found"));
    }

    public void addStudentToTheCourse (StudentRequestDto studentRequestDto){
        studentRepository.save(MapperDtoToStudentEntity.student(studentRequestDto));
        var course = courseRepository.findCourseEntityByName(studentRequestDto.getCourse())
                .orElseThrow(()->new CourseNotFoundException("Course not found.."));
        course.setEnrollment(+1);
    }
}
