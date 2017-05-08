package cl.mineduc.worker_encasillamiento.modelo;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = -1841368222802443902L;
	private Long idPersona;
    private String nombrePersona;
    private String apPaternoPersona;
    private String apMaternoPersona;
    private Integer calidadJuridica;
    private Integer rutPersona;
    private String dvPersona;
    
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long p) {
		this.idPersona = p;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String p) {
		this.nombrePersona = p;
	}
	public String getApPaternoPersona() {
		return apPaternoPersona;
	}
	public void setApPaternoPersona(String p) {
		this.apPaternoPersona = p;
	}
	public String getApMaternoPersona() {
		return apMaternoPersona;
	}
	public void setApMaternoPersona(String p) {
		this.apMaternoPersona = p;
	}
	public Integer getCalidadJuridica() {
		return calidadJuridica;
	}
	public void setCalidadJuridica(Integer p) {
		this.calidadJuridica = p;
	}
	public Integer getRutPersona() {
		return rutPersona;
	}
	public void setRutPersona(Integer p) {
		this.rutPersona = p;
	}
	public String getDvPersona() {
		return dvPersona;
	}
	public void setDvPersona(String p) {
		this.dvPersona = p;
	}   
}
