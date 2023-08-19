package org.examen.PlusTech.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.AsEmbedded;
import org.openxava.annotations.Money;
import org.openxava.annotations.TextArea;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

/*
	Datos del internamiento
    o	Motivo
    o	Fecha de ingreso
    o	Fecha de salida
    o	Peso
    o	Temperatura
    o	Diagnostico
    o	Comentarios
    o	Total a pagar
 */
@Embeddable
@Getter
@Setter
public class DatosInternamiento {

    @Column(length = 100)
    @TextArea
    private String motivo;

    @Column(length = 10)
    private LocalDate fechaIngreso;

    @Column(length = 10)
    private LocalDate fechaSalida;

    @PositiveOrZero
    private BigDecimal pesoGramos;

    @PositiveOrZero
    private BigDecimal temperaturaGradosCelsius;

    @Column(length = 20)
    private String diagnostico;

    @Column(length = 200)
    @TextArea
    private String comentariosInternamiento;

    @Money
    @PositiveOrZero
    @NotNull(message = "El precio no puede quedar VACIO")
    private BigDecimal precioTotal;

    public DatosInternamiento() {
    }

    public DatosInternamiento(String motivo, LocalDate fechaIngreso, LocalDate fechaSalida, BigDecimal pesoGramos, BigDecimal temperaturaGradosCelsius, String diagnostico, String comentariosInternamiento, BigDecimal precioTotal) {
        this.motivo = motivo;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.pesoGramos = pesoGramos;
        this.temperaturaGradosCelsius = temperaturaGradosCelsius;
        this.diagnostico = diagnostico;
        this.comentariosInternamiento = comentariosInternamiento;
        this.precioTotal = precioTotal;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public BigDecimal getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(BigDecimal pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public BigDecimal getTemperaturaGradosCelsius() {
        return temperaturaGradosCelsius;
    }

    public void setTemperaturaGradosCelsius(BigDecimal temperaturaGradosCelsius) {
        this.temperaturaGradosCelsius = temperaturaGradosCelsius;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getComentariosInternamiento() {
        return comentariosInternamiento;
    }

    public void setComentariosInternamiento(String comentariosInternamiento) {
        this.comentariosInternamiento = comentariosInternamiento;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }
}
