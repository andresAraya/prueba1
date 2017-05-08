package cl.mineduc.worker_encasillamiento.modelo;

import java.io.Serializable;

public class InicioGrado implements Serializable{

	private static final long serialVersionUID = 3079488448954518411L;
	private Long iniGraId;
	private Integer iniGraGrado;
	private String iniGraEstamento;
	private Integer iniGraEstado;
	
	public Long getIniGraId() {
		return iniGraId;
	}
	public void setIniGraId(Long ig) {
		this.iniGraId = ig;
	}
	public Integer getIniGraGrado() {
		return iniGraGrado;
	}
	public void setIniGraGrado(Integer ig) {
		this.iniGraGrado = ig;
	}
	public String getIniGraEstamento() {
		return iniGraEstamento;
	}
	public void setIniGraEstamento(String ig) {
		this.iniGraEstamento = ig;
	}
	public Integer getIniGraEstado() {
		return iniGraEstado;
	}
	public void setIniGraEstado(Integer ig) {
		this.iniGraEstado = ig;
	}
}
