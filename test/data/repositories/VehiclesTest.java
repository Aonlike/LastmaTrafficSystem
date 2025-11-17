package data.repositories;

import data.models.Owner;
import data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiclesTest {

    private Vehicles vehicles;

    @BeforeEach
    void setUp() {
        vehicles = new Vehicles();
    }

    @Test
    public void testSaveVehicle() {
        Year year = Year.parse("2015");
        Owner owner = new Owner("Martin", "Some address", "08077663723", "martin@gmail.com", 1L);

        Vehicle vehicle = new Vehicle("Jack", "Abuja", "Black",
                "AB-123-X", year, owner, "Ab7");
        Vehicle savedVehicle = vehicles.save(vehicle);

        System.out.println(savedVehicle);

        Vehicle savedVehicle2 = vehicles.save(savedVehicle);

        assertEquals(vehicle, savedVehicle);
        System.out.println(savedVehicle2);
    }

    @Test
    public void testFindById() {
    Year year = Year.parse("2015");
    Owner owner = new Owner("Martin", "Some address", "08077663723", "martin@gmail.com", 1L);
        Vehicle vehicle = new Vehicle("Jack", "Abuja", "Black",
                "AB-123-X", year, owner, "Ab7");
        Vehicle savedVehicle = vehicles.save(vehicle);

        Vehicle foundVehicle = vehicles.findById(savedVehicle.getId());

        assertEquals(savedVehicle, foundVehicle);
    }

    @Test
    public void testDeleteById() {
    Year year = Year.parse("2015");
    Owner owner = new Owner("Martin", "Some address", "08077663723", "martin@gmail.com", 1L);
        Vehicle vehicle = new Vehicle("Jack", "Abuja", "Black",
                "AB-123-X", year, owner, "Ab7");
        Vehicle savedVehicle = vehicles.save(vehicle);

        vehicles.deleteById(savedVehicle.getId());

        assertEquals(0, vehicles.count());
    }

    @Test
    public void testDelete() {
    Year year = Year.parse("2015");
    Owner owner = new Owner("Martin", "Some address", "08077663723", "martin@gmail.com", 1L);
        Vehicle vehicle = new Vehicle("Jack", "Abuja", "Black",
                "AB-123-X", year, owner, "Ab7");
        Vehicle savedVehicle = vehicles.save(vehicle);

        vehicles.delete(savedVehicle);

        assertEquals(0, vehicles.count());
    }

    @Test
    public void testDeleteAll() {
    Year year = Year.parse("2015");
    Owner owner = new Owner("Martin", "Some address", "08077663723", "martin@gmail.com", 1L);
        Vehicle vehicle = new Vehicle("Jack", "Abuja", "Black",
                "AB-123-X", year, owner, "Ab7");
        vehicles.save(vehicle);

        vehicles.deleteAll();

        assertEquals(0, vehicles.count());
    }
}
