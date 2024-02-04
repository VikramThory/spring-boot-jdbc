package com.vikram.singh.springbootjdbc.services.impl;

import com.vikram.singh.springbootjdbc.converter.Converter;
import com.vikram.singh.springbootjdbc.dto.StudentDto;
import com.vikram.singh.springbootjdbc.repositories.StudentRepository;
import com.vikram.singh.springbootjdbc.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentDto getStudentById(int id) {
        var studentEntity = this.studentRepository.getStudentById(id);
        return Converter.toStudentDto(studentEntity);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        var studentEntityList = this.studentRepository.getAllStudents();
        return Converter.toStudentDtoList(studentEntityList);
    }

    @Override
    public boolean updateStudent(int studentId, StudentDto studentDto) {
        var response = this.studentRepository.updateStudent(studentId, studentDto);
        return response == 1;
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        this.studentRepository.addStudent(studentDto);
    }

    @Override
    public boolean deleteStudent(int id) {
        var response = this.studentRepository.deleteStudent(id);
        return response == 1;
    }
}
