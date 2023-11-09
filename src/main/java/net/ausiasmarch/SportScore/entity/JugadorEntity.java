package net.ausiasmarch.SportScore.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "jugador")
public class JugadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 255)
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 255)
    @Column(name = "apellido_1")
    private String apellido1;

    @Size(max = 255)
    @Column(name = "apellido_2")
    private String apellido2;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "posicion")
    private String posicion;

    @NotNull
    @NotBlank
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @NotNull
    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 6, max = 15)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric")
    @Column(name = "username")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @NotBlank
    @Size(min = 64, max = 64)
    @Pattern(regexp = "^[a-fA-F0-9]+$", message = "Password must be hexadecimal")
    @Column(name = "password")
    private String password = "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e";

    @Column(name = "rol")
    private Boolean role = false;

    @ManyToOne
    @JoinColumn(name = "equipo_id", referencedColumnName = "id")
    private EquipoEntity equipo;
    /*
     * @OneToMany(mappedBy = "jugador", fetch = jakarta.persistence.FetchType.LAZY)
     * private EquipoEntity equipo;
     */

    public JugadorEntity() {
        // Constructor sin argumentos
    }

    public JugadorEntity(Long id, String nombre, String apellido1, String apellido2, String nacionalidad,
            String posicion, LocalDate fechaNacimiento, String email, String username, String password, Boolean role,
            EquipoEntity equipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.equipo = equipo;
    }

    public JugadorEntity(String nombre, String apellido1, String apellido2, String nacionalidad, String posicion,
            LocalDate fechaNacimiento, String email, String username, String password, Boolean role,
            EquipoEntity equipo) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.equipo = equipo;
    }

    public JugadorEntity(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public EquipoEntity getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoEntity equipo) {
        this.equipo = equipo;
    }
}
