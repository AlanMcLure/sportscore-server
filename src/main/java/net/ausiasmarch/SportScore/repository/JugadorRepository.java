package net.ausiasmarch.SportScore.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import net.ausiasmarch.SportScore.entity.JugadorEntity;

public interface JugadorRepository extends JpaRepository<JugadorEntity, Long> {
    
    Optional<JugadorEntity> findByUsername(String username);

    Optional<JugadorEntity> findByUsernameAndPassword(String username, String password);

    @Modifying
    @Query(value = "ALTER TABLE jugador AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
