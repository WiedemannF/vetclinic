package com.javajunior.vetclinic.dbexample.dao;

import com.javajunior.vetclinic.vetservice.model.Owner;
import com.javajunior.vetclinic.vetservice.model.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Slf4j
@Component
public class PetDaoBeans {

    private Connection connection;

    private static final String SQL_QUERY = "SELECT * FROM pets WHERE id = ?";
    public PetDaoBeans(Connection connection) {
        this.connection = connection;
    }

    public Pet getPetById(Integer petId) throws SQLException {

        PreparedStatement selectQuery = connection.prepareStatement(SQL_QUERY);
        selectQuery.setInt(1, petId);
        ResultSet result = selectQuery.executeQuery();
        while (result.next()) {
            Pet pet = new Pet();
            pet.setId(result.getLong("id"));
            pet.setName(result.getString("name"));
            pet.setBreed(result.getString("breed"));
            pet.setSex(result.getString("sex"));
            pet.setDateOfBirth(result.getDate("dateOfBirth").toLocalDate());
            pet.setOwner((Owner) result.getObject("Owner"));
            return pet;
        }

        return null;
    }
}
