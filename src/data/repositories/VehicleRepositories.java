package data.repositories;

import data.models.Vehicle;

import java.util.List;

public interface VehicleRepositories {
    Vehicle save(Vehicle vehicle);

    Vehicle findById(int id);

    List<Vehicle> findAll();

    void deleteById(int id);

    void delete(Vehicle vehicle);

    void deleteAll();

    long count();
    List<Vehicle> findByName(String name);
    Vehicle findByChasisNumber(String chasisNumber);
}
