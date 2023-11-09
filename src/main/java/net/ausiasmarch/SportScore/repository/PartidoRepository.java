package net.ausiasmarch.SportScore.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import net.ausiasmarch.SportScore.entity.PartidoEntity;

public interface PartidoRepository extends JpaRepository<PartidoEntity, Long> {

    @Modifying
    @Query(value = "ALTER TABLE partido AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
