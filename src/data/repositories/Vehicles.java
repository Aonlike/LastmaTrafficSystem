package data.repositories;


import data.models.Vehicle;

import java.util.List;

public class Vehicles implements VehicleRepositories {

    @Override
    public Vehicle save(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle findById(int id) {
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Vehicle vehicle) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Vehicle> findByName(String name) {
        return List.of();
    }

    @Override
    public List<Vehicle> findByRank(String rank) {
        return List.of();
    }
}
