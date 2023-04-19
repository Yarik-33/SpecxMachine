package by.kuchinskiy.speczmachine.service;

import by.kuchinskiy.speczmachine.entity.Machine;
import by.kuchinskiy.speczmachine.repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineService { private final MachineRepository machineRepository;
    public List<Machine> findAll() {
        return machineRepository.findAll();
    }

    public void deleteById(Long id) {
        machineRepository.deleteById(id);
    }

    public Machine findById(Long id) {
        return machineRepository.findById(id).orElseThrow();
    }
    public void save(Machine machine) {
        machineRepository.save(machine);
    }

    public Machine setMachineBody(String name,
                                    Long price
                                    ) throws IOException {

        Machine sneakers = new Machine();
        sneakers.setName(name);
        sneakers.setPrice(price);

        return sneakers;
    }

    public List<Long> findAllId() {
        return machineRepository.findAllId();
    }
}
