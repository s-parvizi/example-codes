package com.example.springdatajdbc;

import com.example.springdatajdbc.respository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJdbcTest
class SpringDataJdbcApplicationTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void test() {

    }
}
