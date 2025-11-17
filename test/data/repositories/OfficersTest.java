package data.repositories;
import data.models.Officer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OfficersTest {
    private OfficerRepositories repo;

    @BeforeEach
    void setUp(){
        repo = new OfficerRepositoryImpl();
    }

    @Test
    public void testSaveOfficer() {
        Officer officer = new Officer();
        repo.save(officer);
        Officer foundOfficer = repo.findById(officer.getId());
        assertNotNull(foundOfficer);
        assertEquals(officer.getId(), foundOfficer.getId());
    }

    @Test
    public void testFindOfficerById() {
        Officer officer = new Officer();
        repo.save(officer);
        Officer foundOfficer = repo.findById(officer.getId());
        assertNotNull(foundOfficer);
        assertEquals(officer.getId(), foundOfficer.getId());
    }

    @Test
    public void testDeleteOfficerById() {
        Officer officer = new Officer();
        Officer savedOfficer = officers.save(officer);
        officers.deleteOfficerById(savedOfficer.getId());
        assertEquals(0, officers.count());
    }

    @Test
    public void testDeleteOfficer() {
        Officer officer = new Officer();
        Officer savedOfficers = officers.save(officer);
        officers.delete(savedOfficers);
        assertEquals(0, officers.count());
    }



}
