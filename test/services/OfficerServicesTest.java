package services;

import data.repositories.OfficerRepositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.OfficerRepositoryImpl;
import traffic_system.domain.Officer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OfficerServicesTest {

    private OfficerServices services;

    @BeforeEach
    void Setup() {
        services = new OfficerRepositories.OfficerServicesImpl(new OfficerRepositoryImpl());
    }

    @Test
    public void testRegisterOfficer() {
        Officer officer = services.registerOfficer("John Smith", "12345");
        assertNotNull(officer.getId());
        assertEquals("John Smith", officer.getName());
        assertEquals("12345", officer.getBadgeNumber());
    }

    @Test
    public void testFindOfficerById() {
        Officer officer = services.registerOfficer("John Smith", "12345");
        Officer fetched = services.findOfficerById(officer.getId());
        assertNotNull(fetched);
        assertEquals("John Smith", fetched.getName());
    }

    @Test
    public void testFindOfficerByBadgeNumber() {
        services.registerOfficer("John Smith", "12345");
        Officer officer = services.findOfficerByBadgeNumber("12345");
        assertNotNull(officer);
        assertEquals("John Smith", officer.getName());
    }

    @Test
    public void testFindAllOfficers() {
        services.registerOfficer("John Smith", "12345");
        services.registerOfficer("Sarah", "12343");

        List<Officer> officers = services.findAllOfficers(); // Corrected comment position

        assertEquals(2, officers.size());
    }

    @Test
    public void testToRemoveOfficer() {
        Officer officer = services.registerOfficer("John Smith", "12345");
        boolean removed = services.deleteOfficerById(officer.getId());
        assertTrue(removed);
        assertNull(services.findOfficerById(officer.getId()));
    }

    @Test
    public void testRemoveOfficerNotFound() {
        assertFalse(services.deleteOfficerById(999));
    }
}
