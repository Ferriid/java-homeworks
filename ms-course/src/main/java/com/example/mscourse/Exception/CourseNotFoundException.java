package com.example.mscourse.Exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message) {
            super(message);
        }
}
