package org.examen.PlusTech.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;


@Entity
@Getter
@Setter

public class Mascota {

    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    private String id;

    @Column(length = 15, name = "descripcion")
    private String nombre;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    private Genero generoDescripcion;


    @Column(length = 10)
    private LocalDate fechaNacimiento;


    @Column(length = 3)
    @ReadOnly
    private int edad;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    private Raza nombreRazaDescripcion;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    private Tamanio tamanioDescripcion;

    @Files
    @Column(length = 32)
    private String fotoMascota;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "mascota_alergia",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "alergia_id")
              )
    private Set<Alergia> alergias = new HashSet<>();

    @ManyToOne
    private Propietario datosPropietario;

    @Embedded
    private DatosInternamiento datosInternamiento;

    @ElementCollection
    private List<HistorialVacunas> historialVacunasLista;

    public Mascota() {
    }

    public Mascota(String id, String nombre, Genero generoDescripcion, LocalDate fechaNacimiento, int edad, Raza nombreRazaDescripcion, Tamanio tamanioDescripcion, String fotoMascota, Set<Alergia> alergias, Propietario datosPropietario, DatosInternamiento datosInternamiento, List<HistorialVacunas> historialVacunasLista) {
        this.id = id;
        this.nombre = nombre;
        this.generoDescripcion = generoDescripcion;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.nombreRazaDescripcion = nombreRazaDescripcion;
        this.tamanioDescripcion = tamanioDescripcion;
        this.fotoMascota = fotoMascota;
        this.alergias = alergias;
        this.datosPropietario = datosPropietario;
        this.datosInternamiento = datosInternamiento;
        this.historialVacunasLista = historialVacunasLista;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        if (fechaNacimiento != null) {
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(fechaNacimiento, currentDate);
            this.edad = period.getYears();
        } else {
            this.edad = 0;
                }
                                    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero getGeneroDescripcion() {
        return generoDescripcion;
    }

    public void setGeneroDescripcion(Genero generoDescripcion) {
        this.generoDescripcion = generoDescripcion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Raza getNombreRazaDescripcion() {
        return nombreRazaDescripcion;
    }

    public void setNombreRazaDescripcion(Raza nombreRazaDescripcion) {
        this.nombreRazaDescripcion = nombreRazaDescripcion;
    }

    public Tamanio getTamanioDescripcion() {
        return tamanioDescripcion;
    }

    public void setTamanioDescripcion(Tamanio tamanioDescripcion) {
        this.tamanioDescripcion = tamanioDescripcion;
    }

    public String getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(String fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public Set<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(Set<Alergia> alergias) {
        this.alergias = alergias;
    }

    public Propietario getDatosPropietario() {
        return datosPropietario;
    }

    public void setDatosPropietario(Propietario datosPropietario) {
        this.datosPropietario = datosPropietario;
    }

    public DatosInternamiento getDatosInternamiento() {
        return datosInternamiento;
    }

    public void setDatosInternamiento(DatosInternamiento datosInternamiento) {
        this.datosInternamiento = datosInternamiento;
    }

    public List<HistorialVacunas> getHistorialVacunasLista() {
        return historialVacunasLista;
    }

    public void setHistorialVacunasLista(List<HistorialVacunas> historialVacunasLista) {
        this.historialVacunasLista = historialVacunasLista;
    }
}


