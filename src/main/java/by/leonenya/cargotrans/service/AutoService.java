package by.leonenya.cargotrans.service;

import by.leonenya.cargotrans.model.Auto;
import by.leonenya.cargotrans.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {

    public AutoRepository autoRepository;

    @Autowired
    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public List<Auto> findAll() {
        return autoRepository.findAll();
    }

    public void delete(Long id) {
        autoRepository.deleteById(id);
    }

    public void save(Auto auto) {
        autoRepository.save(auto);
    }

    public Auto findById(Long id) {
        return autoRepository.getById(id);
    }
}
