package net.ausiasmarch.SportScore.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
import jakarta.validation.constraints.Past;

@Entity
@Table(name = "partido")
public class PartidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha del partido no puede ser nula")
    @Past(message = "La fecha del partido debe estar en el pasado")
    @Column(name = "fecha_partido")
    private LocalDate fechaPartido;

    @NotNull
    @NotBlank
    @Column(name = "resultado")
    private String resultado;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "equipo_local", referencedColumnName = "id")
    private EquipoEntity equipoLocal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "equipo_visitante", referencedColumnName = "id")
    private EquipoEntity equipoVisitante;

    public PartidoEntity() {
        // Constructor vacío
    }

    public PartidoEntity(Long id, LocalDate fechaPartido, String resultado, EquipoEntity equipoLocal,
            EquipoEntity equipoVisitante) {
        this.id = id;
        this.fechaPartido = fechaPartido;
        this.resultado = resultado;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public PartidoEntity(LocalDate fechaPartido, String resultado, EquipoEntity equipoLocal,
            EquipoEntity equipoVisitante) {
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
