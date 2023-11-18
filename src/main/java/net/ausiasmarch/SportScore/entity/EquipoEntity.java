package net.ausiasmarch.SportScore.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "equipo")
public class EquipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * @NotNull
     * 
     * @NotBlank
     */
    @Column(name = "nombre")
    @Size(min = 3, max = 255)
    private String nombre;

    /*
     * @NotNull
     * 
     * @NotBlank
     */
    @Column(name = "pais_origen")
    private String paisOrigen;

    @Column(name = "ciudad_origen")
    private String ciudadOrigen;

    @NotNull(message = "La fecha de fundación no puede ser nula")
    @Past(message = "La fecha de fundación debe estar en el pasado")
    @Column(name = "fecha_fundacion")
    private LocalDate fechaFundacion;

    @Column(name = "entrenador")
    private String entrenador;

    public EquipoEntity() {
        // Constructor sin argumentos
    }

    public EquipoEntity(Long id, String nombre, String paisOrigen, String ciudadOrigen, LocalDate fechaFundacion,
            String entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.ciudadOrigen = ciudadOrigen;
        this.fechaFundacion = fechaFundacion;
        this.entrenador = entrenador;
    }

    public EquipoEntity(String nombre, String paisOrigen, String ciudadOrigen, LocalDate fechaFundacion,
            String entrenador) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.ciudadOrigen = ciudadOrigen;
        this.fechaFundacion = fechaFundacion;
        this.entrenador = entrenador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

}
