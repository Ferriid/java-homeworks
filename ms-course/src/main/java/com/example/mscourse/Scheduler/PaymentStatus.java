package com.example.mscourse.Scheduler;

import com.example.mscourse.Service.CourseService;
import com.example.mscourse.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaymentStatus {

    private final StudentService studentService;

    @Scheduled(cron = "0 0 0 1 * ?")
    public void resetPayments() {
        studentService.resetAllPaymentsToUnpaid();
    }
}
