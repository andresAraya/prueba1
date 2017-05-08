package cl.mineduc.worker_encasillamiento.modelo;

import java.io.Serializable;

public class InicioProce implements Serializable{

	private static final long serialVersionUID = 8378145241884359798L;
	private Long iniProId;
	private Integer iniProEstado;
	
	public Long getIniProId() {
		return iniProId;
	}
	public void setIniProId(Long ip) {
		this.iniProId = ip;
	}
	public Integer getIniProEstado() {
		return iniProEstado;
	}
	public void setIniProEstado(Integer ip) {
		this.iniProEstado = ip;
	}
	
}
