package es.ua.jtech.amigosspring.presentacion;

public class CriteriosBusqueda {

	private int edadMin;
	private int edadMax;
	private String localidad;
	private String sexo;

	public int getEdadMin() {
		return this.edadMin;
	}

	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

	public int getEdadMax() {
		return this.edadMax;
	}

	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
