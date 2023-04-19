package by.kuchinskiy.speczmachine.service;
import by.kuchinskiy.speczmachine.entity.Images;
import by.kuchinskiy.speczmachine.repository.ImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ImagesService {
    private final ImagesRepository imagesRepository;

    public List<Images> findByMachine() {
        return imagesRepository.findByMachineId();
    }

    public Images findFirstForMachine(Long id) {
        return imagesRepository.findAllImagesForMachine(id).get(0);
    }

    public void save(Images images) {
        imagesRepository.save(images);
    }

    public List<Images> findAll() {
        return imagesRepository.findAll();
    }

    public Images findById(Long id) {
        return imagesRepository.findById(id).orElseThrow();
    }

    public List<Images> findAllImagesForMachine(Long id) {
        return imagesRepository.findAllImagesForMachine(id);
    }
}
