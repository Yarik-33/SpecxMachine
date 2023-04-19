package by.kuchinskiy.speczmachine.repository;

import by.kuchinskiy.speczmachine.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Images, Long> {
    @Query("SELECT u FROM Images u WHERE u.machine = ?1")
    public List<Images> findByMachineId();

    @Query("SELECT i FROM Images i WHERE i.machine.id = ?1")
    public Images findFirstForMachine(Long id);

    @Query("SELECT u FROM Images u WHERE u.machine.id = ?1")
    public List<Images> findAllImagesForMachine(Long id);
}
