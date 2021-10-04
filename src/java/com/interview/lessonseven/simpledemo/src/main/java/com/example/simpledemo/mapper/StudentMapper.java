package com.example.simpledemo.mapper;

import com.example.simpledemo.domain.Student;
import com.example.simpledemo.dto.StudentDto;

public class StudentMapper {
    public static Student toStudent(StudentDto dto) {
        return Student.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .build();
    }

    public static StudentDto fromStudent(Student student) {
        return StudentDto.builder()
                .age(student.getAge())
                .name(student.getName())
                .build();
    }
}
