package by.kuchinskiy.speczmachine.repository;

import by.kuchinskiy.speczmachine.entity.Machine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine,Long> {
    @Query("FROM Machine ")
    Page<Machine> getPage(Pageable pageable);

    @Query("SELECT id FROM Machine")
    List<Long> findAllId();
}
