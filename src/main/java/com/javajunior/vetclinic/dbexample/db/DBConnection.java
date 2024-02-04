package com.javajunior.vetclinic.dbexample.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DBConnection {

    INSTANCE;

    private Connection connection;

    public Connection newConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/carservice_db",
                    "postgres",
                    "12345");
        }
        return connection;
    }
}
