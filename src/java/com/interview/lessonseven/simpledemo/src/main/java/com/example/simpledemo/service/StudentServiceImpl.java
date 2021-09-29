package com.example.simpledemo.service;

import com.example.simpledemo.dao.StudentRepository;
import com.example.simpledemo.domain.Student;
import com.example.simpledemo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean save(StudentDto studentDto) {
        Student student = Student.builder()
                .name(studentDto.getName())
                .age(studentDto.getAge())
                .build();
        studentRepository.save(student);
        return true;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findFirstByName(name);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void updateProfile(StudentDto dto) {
        Student savedStudent = studentRepository.findFirstByName(dto.getName());
        if (savedStudent == null) {
            throw new RuntimeException("Student " + dto.getName() + " not found");
        }
        studentRepository.save(savedStudent);
    }

    private StudentDto toDto(Student student) {
        return StudentDto.builder()
                .name(student.getName())
                .age(student.getAge())
                .build();
    }


}
