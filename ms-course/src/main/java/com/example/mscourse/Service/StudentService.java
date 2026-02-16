package com.example.mscourse.Service;

import com.example.mscourse.Dto.StudentRequestDto;
import com.example.mscourse.Entity.StudentEntity;
import com.example.mscourse.Enums.PaymentStatus;
import com.example.mscourse.Exception.CourseNotFoundException;
import com.example.mscourse.Exception.StudentNotFoundException;
import com.example.mscourse.Mapper.MapperDtoToStudentEntity;
import com.example.mscourse.Repository.CourseRepository;
import com.example.mscourse.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    public StudentEntity findByStudentId(String id) {
        return studentRepository.findByStudentId(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public void addStudentToTheCourse(StudentRequestDto studentRequestDto) {
        var course = courseRepository.findCourseEntityByCourseId(studentRequestDto.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException("Course not found.."));
        course.setEnrollment(course.getEnrollment() + 1);
        courseRepository.save(course);
        var student = MapperDtoToStudentEntity.student(studentRequestDto, course);
        studentRepository.save(student);
    }

    @Transactional
    public void resetAllPaymentsToUnpaid() {
        studentRepository.findAll().forEach(student ->
            student.setPaymentStatus(PaymentStatus.UNPAID));

    }
}