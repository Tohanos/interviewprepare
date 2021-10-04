package com.example.simpledemo.service;

import com.example.simpledemo.domain.Student;
import com.example.simpledemo.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    boolean save(StudentDto studentDto);
    void save(Student student);
    List<StudentDto> getAll();
    Student findByName(String name);
    Optional<Student> findById(Long id);
    void updateProfile(StudentDto studentDto);

}
