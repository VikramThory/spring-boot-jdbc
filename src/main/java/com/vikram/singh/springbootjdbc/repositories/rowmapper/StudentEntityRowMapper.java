package com.vikram.singh.springbootjdbc.repositories.rowmapper;

import com.vikram.singh.springbootjdbc.datamodel.StudentEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentEntityRowMapper implements RowMapper<StudentEntity> {
    @Override
    public StudentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new StudentEntity(rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("standard"),
                rs.getString("section"),
                rs.getTimestamp("creation_time").toLocalDateTime(),
                rs.getTimestamp("modification_time") != null ? rs.getTimestamp("modification_time").toLocalDateTime() : null);
    }
}
