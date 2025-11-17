package data.repositories;

import data.models.Officer;
import services.OfficerServices;

import java.util.List;

public interface OfficerRepositories {
    void save(Officer officer);

    Officer findById(int id);

    List<Officer> findAll();

    void deleteOfficerById(int id);

    void delete(Officer officer);

    Officer findOfficerById(int id);

}
