package net.ausiasmarch.SportScore.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "partido")
public class PartidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private LocalDate fechaPartido;

    @NotNull
    @NotBlank
    private String resultado;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "equipoLocal", referencedColumnName = "id")
    private EquipoEntity equipoLocal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "equipoVisitante", referencedColumnName = "id")
    private EquipoEntity equipoVisitante;

    public PartidoEntity(Long id, LocalDate fechaPartido, String resultado, EquipoEntity equipoLocal, EquipoEntity equipoVisitante) {
        this.id = id;
        this.fechaPartido = fechaPartido;
        this.resultado = resultado;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public PartidoEntity(LocalDate fechaPartido, String resultado, EquipoEntity equipoLocal, EquipoEntity equipoVisitante) {
        this.fechaPartido = fechaPartido;
        this.resultado = resultado;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getfechaPartido() {
        return fechaPartido;
    }

    public void setfechaPartido(LocalDate fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getResultado() {
        return resultado;
    }

    public void setresultado(String resultado) {
        this.resultado = resultado;
    }

    public EquipoEntity getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(EquipoEntity equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public EquipoEntity getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(EquipoEntity equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
}
