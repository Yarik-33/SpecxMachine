package by.kuchinskiy.speczmachine.controller;

import by.kuchinskiy.speczmachine.entity.Images;
import by.kuchinskiy.speczmachine.entity.Machine;
import by.kuchinskiy.speczmachine.service.ImagesService;
import by.kuchinskiy.speczmachine.service.MachineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/machine")
@RequiredArgsConstructor
@Controller
@Slf4j
public class MachineController {
    private final MachineService machineService;
    private final ImagesService imagesService;
    @GetMapping
    public String showSneakers(Model model) {
        model.addAttribute("machine", machineService.findAll());
        List<Machine> sneakers = machineService.findAll();
        return "machineProduct";
    }
    @GetMapping("/{id}")
    public String product(@PathVariable Long id, Model model) {
        Machine machine = machineService.findById(id);
        model.addAttribute("product", machine);
        model.addAttribute("productImages", imagesService.findAllImagesForMachine(id));

        return "machineProduct";
    }
    @PostMapping("/add")
    public String addMachine(
            @RequestParam("name") String name,
            @RequestParam("price") Long price,
            @RequestParam("image") List<MultipartFile> images) throws IOException {
        Machine machine = machineService.setMachineBody(name, price);
        machineService.save(machine);


        for(int i = 0; i < images.size(); i++) {
            Images newImages = new Images();
            newImages.setImage(images.get(i).getBytes());
            newImages.setMachine(machine);
            machine.getImages().add(newImages);
            imagesService.save(newImages);
        }

        return "redirect:/adminMenu";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("machineId") Long id, Model model) {
        log.info("Machine with id {} was deleted", id);

        List<Long> idList = machineService.findAllId();

        if (!idList.contains(id)) {
            model.addAttribute("deleteResult", "Machine with this ID is not found");
            model.addAttribute("machine", machineService.findAll());
            return "adminMain";
        }

        machineService.deleteById(id);
        model.addAttribute("deleteResult", "Success delete");
        model.addAttribute("machines", machineService.findAll());
        return "adminMain";
    }
}
