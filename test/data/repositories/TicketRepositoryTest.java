package data.repositories;

import data.models.Offence;
import data.models.Owner;
import data.models.Ticket;
import data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TicketRepositoryTest {
    private TicketRepository repo;

    @BeforeEach
    public void setup() {
        repo = new TicketRepository();
    }

    @Test
    public void testSaveTicket() {
        Owner owner = new Owner("Martin","Lagos","090667777", "Male", "Martn@gmail.com","Matt");
        Year year = Year.parse("2015");
        Vehicle vehicle = new Vehicle("toyota", "camry", "w343gg", "blue", year, owner, "1212gs" );
        Ticket ticket = new Ticket(1, vehicle,false);
        repo.save(ticket);
        Ticket fetched = repo.findById(1);
        fetched = repo.findById(2);
        System.out.println(ticket);
    }

    @Test
    public void testFindByVehicleId() {
      Year year = Year.parse("2015");
       Owner owner = new Owner("Martin","Lagos","090667777", "Male", "Martn@gmail.com","Matt");

         Vehicle vehicle1 = new Vehicle("Toyota", "Camry", "AAA111", "Red", year, owner, "V1");
          Vehicle vehicle2 = new Vehicle("Honda", "Accord", "BBB222", "Blue", year, owner, "V2");

            repo.save(new Ticket(1, vehicle1, true));
            repo.save(new Ticket(2, vehicle2, false));

            List<Ticket> tickets = repo.findByVehicleId(2);
            assertEquals(1, tickets.size()); // Expecting only the ticket with ID 2
        }

    @Test
    public void testFindAll() {
        Year year = Year.parse("2015");
        Owner owner = new Owner("Martin","Lagos","090667777", "Male", "Martn@gmail.com","Matt");

        Vehicle vehicle1 = new Vehicle("Toyota", "Camry", "AAA111", "Red", year, owner, "V1");
        Vehicle vehicle2 = new Vehicle("Honda", "Accord", "BBB222", "Blue", year, owner, "V2");

        repo.save(new Ticket(1, vehicle1, false));
        repo.save(new Ticket(2, vehicle2, false));
        List<Ticket> tickets = repo.findAll();
        assertEquals(2, tickets.size());
    }

    @Test
    public void testDeleteById() {
        Year year = Year.parse("2015");
        Owner owner = new Owner("Martin","Lagos","090667777", "Male", "Martn@gmail.com","Matt");
        Vehicle vehicle1 = new Vehicle("Toyota", "Camry", "AAA111", "Red", year, owner, "V1");
       repo.save(new Ticket(1, vehicle1, false));
       repo.deleteById(1);
        assertNull(repo.findById(1));
    }
}