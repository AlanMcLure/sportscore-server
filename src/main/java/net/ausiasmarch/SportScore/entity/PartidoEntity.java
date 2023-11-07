package net.ausiasmarch.SportScore.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "partido")
public class PartidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private Date fechaPartido;

    private String resultado;

    public PartidoEntity(Long id, Date fechaPartido, String resultado) {
        this.id = id;
        this.fechaPartido = fechaPartido;
        this.resultado = resultado;
    }

    public PartidoEntity(Date fechaPartido, String resultado) {
        this.fechaPartido = fechaPartido;
        this.resultado = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getfechaPartido() {
        return fechaPartido;
    }

    public void setfechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getResultado() {
        return resultado;
    }

    public void setresultado(String resultado) {
        this.resultado = resultado;
    }

}
