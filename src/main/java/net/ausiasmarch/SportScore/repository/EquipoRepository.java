package net.ausiasmarch.SportScore.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import net.ausiasmarch.SportScore.entity.EquipoEntity;
import net.ausiasmarch.SportScore.entity.JugadorEntity;

public interface EquipoRepository extends JpaRepository<EquipoEntity, Long> {
    
    Optional<EquipoEntity> findByNombre(String nombre);

    @Modifying
    @Query(value = "ALTER TABLE equipo AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
