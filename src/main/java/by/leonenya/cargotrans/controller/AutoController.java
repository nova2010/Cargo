package by.leonenya.cargotrans.controller;

import by.leonenya.cargotrans.model.Auto;
import by.leonenya.cargotrans.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/auto")
public class AutoController {

    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Auto> autos = autoService.findAll();
        model.addAttribute("autos", autos);

        return "auto";
    }

    @GetMapping("/create")
    public String createForm(Auto auto) {
        return "auto-create";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        Auto auto = autoService.findById(id);
        model.addAttribute("auto", auto);

        return "auto-update";
    }

    @PostMapping("/create")
    public String save(Auto auto) {
        autoService.save(auto);
        return "redirect:/auto";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        autoService.delete(id);
        return "redirect:/auto";
    }

}
