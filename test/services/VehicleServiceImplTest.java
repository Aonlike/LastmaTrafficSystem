package services;

import data.repositories.VehicleRepositories;
import data.repositories.Vehicles;
import dtos.requests.RegisterVehicleRequest;
import exceptions.VehicleExistsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceImplTest {

    VehicleServiceImpl vehicleService;
    VehicleRepositories vehicleRepositories;

    @BeforeEach
    void setUp() {
        vehicleService = new VehicleServiceImpl();
        vehicleRepositories = new Vehicles();
    }

    @Test
    public void test(){
        RegisterVehicleRequest request = new RegisterVehicleRequest();
        request.setVehicleName("camry");
        request.setChasisNumber("12345");
        request.setVehicleModel("Corolla E");
        request.setVehicleColor("black");
        vehicleService.registerVehicle(request);
        assertEquals(1, vehicleRepositories.count());
        System.out.println(vehicleRepositories.findAll());
    }

    @Test
    public void test1(){
        RegisterVehicleRequest request = new RegisterVehicleRequest();
        request.setChasisNumber("huty");
        vehicleService.registerVehicle(request);
        assertEquals(1, vehicleRepositories.count());
        assertThrows(VehicleExistsException.class, () -> vehicleService.registerVehicle(new RegisterVehicleRequest()));
    }

    @AfterEach
    void tearDown(){
        vehicleRepositories.deleteAll();
    }


}