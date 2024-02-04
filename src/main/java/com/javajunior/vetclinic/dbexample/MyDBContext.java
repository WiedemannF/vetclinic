package com.javajunior.vetclinic.dbexample;

import com.javajunior.vetclinic.dbexample.dao.PetDaoBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class MyDBContext {
    @Bean
    public Connection getDataBaseConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/vetservice_db",
                "postgres",
                "12345");
    }

    @Bean
    public PetDaoBeans petDaoBeans() throws SQLException {
        return new PetDaoBeans(getDataBaseConnection());
    }
}
