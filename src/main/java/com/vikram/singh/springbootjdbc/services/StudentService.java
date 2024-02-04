package com.vikram.singh.springbootjdbc.services;

import com.vikram.singh.springbootjdbc.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto getStudentById(int id);

    List<StudentDto> getAllStudents();

    boolean updateStudent(int studentId, StudentDto studentDto);

    void addStudent(StudentDto studentDto);

    boolean deleteStudent(int id);
}
