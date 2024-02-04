package com.vikram.singh.springbootjdbc.repositories.impl;

import com.vikram.singh.springbootjdbc.datamodel.StudentEntity;
import com.vikram.singh.springbootjdbc.dto.StudentDto;
import com.vikram.singh.springbootjdbc.repositories.StudentRepository;
import com.vikram.singh.springbootjdbc.repositories.rowmapper.StudentEntityRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final DataSource dataSource;

    public StudentRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public StudentEntity getStudentById(int id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = String.format("select * from public.\"student\" where \"id\" = %d", id);
        return template.queryForObject(query, new StudentEntityRowMapper());
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "select * from public.\"student\"";
        return template.query(query, new StudentEntityRowMapper());
    }

    @Override
    public boolean addStudent(StudentDto studentDto) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = "insert into public.\"student\"(\"name\", \"standard\", \"section\", \"creation_time\", \"modification_time\") values (?, ?, ?, ?, ?)";
        return Boolean.TRUE.equals(template.execute(query, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setString(1, studentDto.name());
            ps.setInt(2, studentDto.standard());
            ps.setString(3, studentDto.section());
            ps.setString(4, LocalDateTime.now().toString());
            ps.setString(5, null);
            return ps.execute();
        }));
    }

    @Override
    public int updateStudent(int studentId, StudentDto studentDto) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = String.format("update public.\"student\" set \"name\" = '%s', \"standard\" = %d, \"section\" = '%s', \"modification_time\" = '%s' where \"id\" = %d",
                studentDto.name(), studentDto.standard(), studentDto.section(), LocalDateTime.now(), studentId);
        return template.update(query);
    }

    @Override
    public int deleteStudent(int id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String query = String.format("delete from public.\"student\" where \"id\" = %d", id);
        return template.update(query);
    }
}
