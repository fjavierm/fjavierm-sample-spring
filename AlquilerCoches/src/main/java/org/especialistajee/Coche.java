/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.especialistajee;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author especialista
 */
public class Coche implements Serializable {

	private static final long serialVersionUID = -161534091108046354L;

	@Length(min = 7, max = 7)
	private String matricula;
	private String modelo;
	@Past
	@DateTimeFormat(style = "S-")
	private Date fechaMatriculacion;
	@Min(0)
	private int km;
	@Min(0)
	@NumberFormat(style = NumberFormat.Style.CURRENCY)
	private BigDecimal precio;

	public Date getFechaMatriculacion() {
		return this.fechaMatriculacion;
	}

	public void setFechaMatriculacion(Date fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public int getKm() {
		return this.km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
