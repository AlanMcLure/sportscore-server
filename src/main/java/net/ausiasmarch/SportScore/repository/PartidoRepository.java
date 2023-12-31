package net.ausiasmarch.SportScore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import net.ausiasmarch.SportScore.entity.PartidoEntity;

public interface PartidoRepository extends JpaRepository<PartidoEntity, Long> {

    Page<PartidoEntity> findByEquipoLocalIdOrEquipoVisitanteId(Long equipoLocalId, Long equipoVisitanteId,
            Pageable pageable);

    @Modifying
    @Query(value = "ALTER TABLE partido AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
