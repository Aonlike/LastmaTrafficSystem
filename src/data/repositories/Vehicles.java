package data.repositories;


import data.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Vehicles implements VehicleRepositories {
    static List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;

    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public void deleteById(int id) {
        for(Vehicle vehicle : vehicles) {
            if(vehicle.getId() == id ){
                vehicles.remove(vehicle);
                break;
            }

        }

    }

    @Override
    public void delete(Vehicle vehicle) {
        vehicles.remove(vehicle);

    }

    @Override
    public void deleteAll() {
        vehicles.clear();

    }

    @Override
    public long count() {
        return vehicles.size();
    }

    @Override
    public List<Vehicle> findByName(String name) {
        return List.of();
    }

    @Override
    public Vehicle findByChasisNumber(String chasisNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getChasisNumber().equals(chasisNumber)) return vehicle;

        }
        return null;
    }
}
