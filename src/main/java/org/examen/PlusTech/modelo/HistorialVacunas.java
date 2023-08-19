package org.examen.PlusTech.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.TextArea;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

/*
?	Historial de vacunas
    o	Fecha
    o	Tipo
    o	Comentarios
 */

@Embeddable
@Getter
@Setter
public class HistorialVacunas {

    @Column(length = 10)
    private LocalDate fechaVacuna;

    @Column(length = 15)
    private String tipo;

    @Column(length = 100)
    @TextArea
    private String comentariosVacunas;

    public HistorialVacunas() {
    }

    public HistorialVacunas(LocalDate fechaVacuna, String tipo, String comentariosVacunas) {
        this.fechaVacuna = fechaVacuna;
        this.tipo = tipo;
        this.comentariosVacunas = comentariosVacunas;
    }

    public LocalDate getFechaVacuna() {
        return fechaVacuna;
    }

    public void setFechaVacuna(LocalDate fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComentariosVacunas() {
        return comentariosVacunas;
    }

    public void setComentariosVacunas(String comentariosVacunas) {
        this.comentariosVacunas = comentariosVacunas;
    }
}
