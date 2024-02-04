package com.vikram.singh.springbootjdbc.repositories;

import com.vikram.singh.springbootjdbc.datamodel.StudentEntity;
import com.vikram.singh.springbootjdbc.dto.StudentDto;

import java.util.List;

public interface StudentRepository {
    StudentEntity getStudentById(int id);

    List<StudentEntity> getAllStudents();

    boolean addStudent(StudentDto studentDto);

    int updateStudent(int studentId, StudentDto studentDto);

    int deleteStudent(int id);
}
