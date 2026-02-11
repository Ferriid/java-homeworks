package com.example.mscourse.Repository;

import com.example.mscourse.Dto.CourseResponseDto;
import com.example.mscourse.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    //CourseEntity findCourseEntityByName(String name);
    Optional<CourseEntity> findCourseEntityByName(String name);

    CourseResponseDto findCourseEntityById(Long id);
}
