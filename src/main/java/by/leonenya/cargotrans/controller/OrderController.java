package by.leonenya.cargotrans.controller;

import by.leonenya.cargotrans.model.Auto;
import by.leonenya.cargotrans.model.Customer;
import by.leonenya.cargotrans.model.Driver;
import by.leonenya.cargotrans.model.Order;
import by.leonenya.cargotrans.service.AutoService;
import by.leonenya.cargotrans.service.CustomerService;
import by.leonenya.cargotrans.service.DriverService;
import by.leonenya.cargotrans.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final AutoService autoService;
    private final CustomerService customerService;
    private final DriverService driverService;

    @Autowired
    public OrderController( OrderService orderService, AutoService autoService, CustomerService customerService,
                            DriverService driverService) {
        this.orderService = orderService;
        this.autoService = autoService;
        this.customerService = customerService;
        this.driverService = driverService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);

        return "order";
    }

    @GetMapping("/create")
    public String createForm(Model model, Order order) {
        List<Auto> autos = autoService.findAll();
        List<Customer> customers = customerService.findAll();
        List<Driver> drivers = driverService.findAll();

        model.addAttribute("autos", autos);
        model.addAttribute("customers", customers);
        model.addAttribute("drivers", drivers);

        return "order-create";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        Order order = orderService.findById(id);
        List<Auto> autos = autoService.findAll();
        List<Customer> customers = customerService.findAll();
        List<Driver> drivers = driverService.findAll();

        model.addAttribute("order", order);
        model.addAttribute("autos", autos);
        model.addAttribute("customers", customers);
        model.addAttribute("drivers", drivers);

        return "order-update";
    }

    @PostMapping("/create")
    public String save(Order order) {
        orderService.save(order);
        return "redirect:/order";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        orderService.delete(id);
        return "redirect:/order";
    }
}
