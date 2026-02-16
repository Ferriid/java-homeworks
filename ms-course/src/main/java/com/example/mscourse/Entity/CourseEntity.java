package com.example.mscourse.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "course_id", nullable = false)
    private String courseId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column (name = "enrollment")
    private Integer enrollment = 0;

    @Column(name = "course_price")
    private Double coursePrice;

    @Column(name = "teacher_salary")
    private Double teacherSalary;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


}
