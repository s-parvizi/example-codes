package com.example.springdatajdbc.domain;

import lombok.Value;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Value
public class CustomerCountRowMapper implements RowMapper {
    @Override
    public CustomerCount mapRow(ResultSet resultSet, int i) throws SQLException {
        CustomerCount customerCount = new CustomerCount();
        customerCount.setName(resultSet.getString("name"));
        customerCount.setCount(resultSet.getLong("count"));
        return customerCount;
    }
}
