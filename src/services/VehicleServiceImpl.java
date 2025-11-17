package services;

import data.models.Owner;
import data.models.Vehicle;
import data.repositories.VehicleRepositories;
import data.repositories.Vehicles;
import dtos.requests.RegisterVehicleRequest;
import dtos.responses.RegisterVehicleResponse;
import exceptions.VehicleExistsException;
import utils.Mapper;

import java.time.Year;

import static utils.Mapper.map;

public class VehicleServiceImpl implements VehicleService {
    private VehicleRepositories vehicleRepositories = new Vehicles();


    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
        Year year = Year.parse("2022");
        Owner owner = new Owner("Jack","Abuja","08077663723","Male","Martin@gmail.com","Ab7");
        Vehicle vehicle = new Vehicle("toyota", "camry", "w343gg", "blue", year, owner, "1212gs");
        if(vehicleRepositories.findByChasisNumber(vehicle.getChasisNumber()) != null){
            throw new VehicleExistsException("vehicle already exist");
        }
        vehicle = map(request);
        vehicleRepositories.save(vehicle);
        return Mapper.map(vehicle);
    }
}
