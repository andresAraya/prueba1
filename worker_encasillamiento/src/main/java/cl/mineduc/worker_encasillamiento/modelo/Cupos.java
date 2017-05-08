package cl.mineduc.worker_encasillamiento.modelo;

import java.io.Serializable;

public class Cupos implements Serializable{

	private static final long serialVersionUID = -4060378349246925456L;
    private Long idCupos;
    private Integer cantidadCupos;
    //private EstamentoGrado estamentoGrado;
    //private Localidades localidades;
    //campo para que sirve para la notificacion 
    //private List<Long> notificacionACupos;
    
    private EstadosRanking estadosRanking;
	public Long getIdCupos() {
		return idCupos;
	}
	public void setIdCupos(Long c) {
		this.idCupos = c;
	}
	public Integer getCantidadCupos() {
		return cantidadCupos;
	}
	public void setCantidadCupos(Integer c) {
		this.cantidadCupos = c;
	}
	public EstadosRanking getEstadosRanking() {
		return estadosRanking;
	}
	public void setEstadosRanking(EstadosRanking c) {
		this.estadosRanking = c;
	}

    
}
