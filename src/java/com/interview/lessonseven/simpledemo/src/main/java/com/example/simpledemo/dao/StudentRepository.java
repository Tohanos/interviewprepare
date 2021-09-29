package com.example.simpledemo.dao;

import com.example.simpledemo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findFirstByName(String name);
}
