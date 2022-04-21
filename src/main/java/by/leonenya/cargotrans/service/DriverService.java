package by.leonenya.cargotrans.service;

import by.leonenya.cargotrans.model.Driver;
import by.leonenya.cargotrans.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    public DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public void delete(Long id) {
        driverRepository.deleteById(id);
    }

    public void save(Driver driver) {
        driverRepository.save(driver);
    }

    public Driver findById(Long id) {
        return driverRepository.getById(id);
    }
}
