package by.kuchinskiy.speczmachine.repository;

import by.kuchinskiy.speczmachine.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine,Long> {
    @Query("SELECT u FROM Machine u WHERE u.discount > 0")
    List<Machine> findAllWithDiscount();

    @Query("SELECT id FROM Machine")
    List<Long> findAllId();
}
