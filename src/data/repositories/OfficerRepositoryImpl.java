package data.repositories;

import data.models.Officer;

import java.util.ArrayList;
import java.util.List;

public class OfficerRepositoryImpl implements OfficerRepositories {
    private List<Officer> officers;

    public OfficerRepositoryImpl() {
        officers = new ArrayList<>();
    }

    @Override
    public void save(Officer officer) {
        if (officer == null) {
            return;
        }
        Officer existing = findById(officer.getId());
        if (existing != null) {
            officers.remove(existing);
        }
        officers.add(officer);
    }

    @Override
    public Officer findById(int id) {
        if (id == 0) {
            return null;
        }
        for (Officer officer : officers) {
            if (officer.getId() == id) {
                return officer;
            }
        }
        return null;
    }

    @Override
    public List<Officer> findAll() {
        return new ArrayList<>(officers);
    }

    @Override
    public void deleteOfficerById(int id) {
        Officer officer = findById(id);
        if (officer != null) {
            officers.remove(officer);
        }
    }

    @Override
    public void delete(Officer officer) {
        Officer officer1 = findById(officer.getId());
        if (officer1 != null) {
            officers.remove(officer1);
        }
    }

}
