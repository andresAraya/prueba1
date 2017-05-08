package cl.mineduc.worker_encasillamiento.modelo;

import java.io.Serializable;
import java.util.Date;

public class Ranking implements Serializable{

	private static final long serialVersionUID = 2054374364634217073L;
    private Long idRanking;
    private Persona persona;
    private Cupos cupos;  
    private Integer tipoRanking, orden, puntaje, estado;
    private Date fechaNotificacion, fechaVencimimento, fechaReiteracion;
    
	public Long getIdRanking() {
		return idRanking;
	}
	public void setIdRanking(Long r) {
		this.idRanking = r;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona r) {
		this.persona = r;
	}
	public Cupos getCupos() {
		return cupos;
	}
	public void setCupos(Cupos r) {
		this.cupos = r;
	}
	public Integer getTipoRanking() {
		return tipoRanking;
	}
	public void setTipoRanking(Integer r) {
		this.tipoRanking = r;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer r) {
		this.orden = r;
	}
	public Integer getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Integer r) {
		this.puntaje = r;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer r) {
		this.estado = r;
	}
	public Date getFechaNotificacion() {
		return fechaNotificacion;
	}
	public void setFechaNotificacion(Date r) {
		this.fechaNotificacion = r;
	}
	public Date getFechaVencimimento() {
		return fechaVencimimento;
	}
	public void setFechaVencimimento(Date r) {
		this.fechaVencimimento = r;
	}
	public Date getFechaReiteracion() {
		return fechaReiteracion;
	}
	public void setFechaReiteracion(Date r) {
		this.fechaReiteracion = r;
	}  
}
