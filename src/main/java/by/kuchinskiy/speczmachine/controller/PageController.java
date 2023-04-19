package by.kuchinskiy.speczmachine.controller;

import by.kuchinskiy.speczmachine.service.MachineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class PageController {
    private final MachineService machineService;
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/registretion")
    public String registration() {
        return "registretion";
    }
    @GetMapping("/main")
    public String main() throws IOException {
        return "index";
    }
    @GetMapping("/addMachine")
    public String addProducts() {
        return "addMachine";
    }
    @GetMapping("/admMain")
    public String adminPage(Model model) {
        model.addAttribute("machine", machineService.findAll());
        return "adminMain";
    }
    @PostMapping("/delete")
    public String deleteDiv() {
        return "index";
    }

}