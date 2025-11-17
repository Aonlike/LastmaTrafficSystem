package utils;

import data.models.Owner;
import data.models.Vehicle;
import dtos.requests.RegisterVehicleRequest;
import dtos.responses.RegisterVehicleResponse;

import java.time.Year;
import java.time.YearMonth;

public class Mapper {

    public static Vehicle map(RegisterVehicleRequest request) {

        Year year = Year.parse("2022");

        Owner owner = new Owner(
                request.getOwnerName(),
                request.getOwnerAddress(),
                request.getOwnerPhone(),
                request.getOwnerEmail(),
                request.getOwnerId()
        );

        Vehicle vehicle = new Vehicle(
                request.getVehicleName(),
                request.getVehicleModel(),
                request.getVehicleColor(),
                request.getPlateNumber(),
                year,
                owner,
                request.getChasisNumber()
        );

        vehicle.setName(request.getVehicleName());
        vehicle.setColor(request.getVehicleColor());
        vehicle.setModel(request.getVehicleModel());
        vehicle.setPlateNumber(request.getPlateNumber());
        vehicle.setChasisNumber(request.getChasisNumber());

        owner.setName(request.getOwnerName());
        owner.setEmail(request.getOwnerEmail());
        owner.setPhone(request.getOwnerPhone());
        owner.setAddress(request.getOwnerAddress());

        return vehicle;
    }

    public static RegisterVehicleResponse map(Vehicle vehicle) {
        RegisterVehicleResponse response = new RegisterVehicleResponse();
        response.setMessage("Success");
        return response;
    }
}
