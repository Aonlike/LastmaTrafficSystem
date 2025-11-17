package data.repositories;

import data.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {

    private final List<Ticket> tickets = new ArrayList<>();

    public void save(Ticket ticket) {
        tickets.add(ticket);
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public List<Ticket> findByVehicleId(int vehicleId) {
        List<Ticket> results = new ArrayList<>();

        for (Ticket t : tickets) {
            if (t.getVehicle().getId() == vehicleId) {
                results.add(t);
            }
        }
        return results;
    }

    public void deleteById(int id) {
        Ticket ticketToDelete = null;

        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                ticketToDelete = ticket;
                break;
            }
        }

        if (ticketToDelete != null) {
            tickets.remove(ticketToDelete);
        }
    }

    public List<Ticket> findAll() {
        return tickets;
    }
}
