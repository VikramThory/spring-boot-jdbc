package com.vikram.singh.springbootjdbc.converter;

import com.vikram.singh.springbootjdbc.datamodel.StudentEntity;
import com.vikram.singh.springbootjdbc.dto.StudentDto;

import java.util.List;

public class Converter {

    public static StudentDto toStudentDto(StudentEntity studentEntity) {
        return new StudentDto(studentEntity.name(), studentEntity.standard(), studentEntity.section());
    }

    public static List<StudentDto> toStudentDtoList(List<StudentEntity> studentEntityList) {
        return studentEntityList
                .stream()
                .map(Converter::toStudentDto)
                .toList();
    }

}
