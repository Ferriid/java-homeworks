package com.example.mscourse.Entity;

import com.example.mscourse.Enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")

public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "student_id",nullable = false)
    private String studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "course")
    private String course;

    @Column(name = "course_id", nullable = false)
    private String courseId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column (name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status",nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;


    @Column(name = "email")
    private String email;

    @Column(name = "education_started", nullable = false)
    private LocalDateTime educationStarted = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt= LocalDateTime.now();

}
