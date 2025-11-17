package data.models;

import java.time.Year;
import java.util.List;

public class Vehicle {

    String name;
    String model;
    String color;
    Year year;
    String plateNumber;
    Owner owner;
    String chasisNumber;

    public Vehicle(String name, String model, String plateNumber, String color, Year year, Owner owner, String chasisNumber) {
        this.name = name;
        this.model = model;
        this.plateNumber = plateNumber;
        this.color = color;
        this.year = year;
        this.owner = owner;
        this.chasisNumber = chasisNumber;
    }

    public String getChasisNumber() {
        return chasisNumber;
    }

    public void setChasisNumber(String chasisNumber) {
        this.chasisNumber = chasisNumber;
    }


    int id;
    List<Ticket> tickets;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
            this.id = id;
    }

    public int getId() {
        return id;
    }
}
