package by.leonenya.cargotrans.controller;

import by.leonenya.cargotrans.model.Driver;
import by.leonenya.cargotrans.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Driver> drivers = driverService.findAll();
        model.addAttribute("drivers", drivers);

        return "driver";
    }

    @GetMapping("/create")
    public String createForm(Driver driver) {
        return "driver-create";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        Driver driver = driverService.findById(id);
        model.addAttribute("driver", driver);

        return "driver-update";
    }

    @PostMapping("/create")
    public String save(Driver driver) {
        driverService.save(driver);
        return "redirect:/driver";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        driverService.delete(id);
        return "redirect:/driver";
    }

}
