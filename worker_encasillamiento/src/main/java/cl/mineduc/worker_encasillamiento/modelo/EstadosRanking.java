package cl.mineduc.worker_encasillamiento.modelo;

import java.io.Serializable;

public class EstadosRanking implements Serializable{

	private static final long serialVersionUID = 1247074444470775158L;
	private Long idEstadoRanking, idRanking, idEstamento;
	private Integer totalEstadoRanking, cuposEstadoRanking, aceptadosEstadoRanking, rechazadosEstadoRanking, estadosRanking, estadoRestantes;
	
	public Long getIdEstadoRanking() {
		return idEstadoRanking;
	}
	public void setIdEstadoRanking(Long er) {
		this.idEstadoRanking = er;
	}
	public Long getIdRanking() {
		return idRanking;
	}
	public void setIdRanking(Long er) {
		this.idRanking = er;
	}
	public Long getIdEstamento() {
		return idEstamento;
	}
	public void setIdEstamento(Long er) {
		this.idEstamento = er;
	}
	public Integer getTotalEstadoRanking() {
		return totalEstadoRanking;
	}
	public void setTotalEstadoRanking(Integer er) {
		this.totalEstadoRanking = er;
	}
	public Integer getCuposEstadoRanking() {
		return cuposEstadoRanking;
	}
	public void setCuposEstadoRanking(Integer er) {
		this.cuposEstadoRanking = er;
	}
	public Integer getAceptadosEstadoRanking() {
		return aceptadosEstadoRanking;
	}
	public void setAceptadosEstadoRanking(Integer er) {
		this.aceptadosEstadoRanking = er;
	}
	public Integer getRechazadosEstadoRanking() {
		return rechazadosEstadoRanking;
	}
	public void setRechazadosEstadoRanking(Integer er) {
		this.rechazadosEstadoRanking = er;
	}
	public Integer getEstadosRanking() {
		return estadosRanking;
	}
	public void setEstadosRanking(Integer er) {
		this.estadosRanking = er;
	}
	public Integer getEstadoRestantes() {
		return estadoRestantes;
	}
	public void setEstadoRestantes(Integer er) {
		this.estadoRestantes = er;
	}
	
	

	
}
