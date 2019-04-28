package dataModel;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="estadisticas")
@NamedQuery(name="Estadisticas.findAll", query="SELECT e FROM Estadisticas e")
public class Estadisticas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int usuarios_id;
	
	private String niveljugador;
	
	private int totalpartidas;
	
	private int partidasganadas;
	
	private int partidasperdidas;
	
	private float porcentajevictorias;
	
	public Estadisticas() {
		
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	public int getUsuarios_id() {
		return usuarios_id;
	}

	public void setUsuarios_id(int usuarios_id) {
		this.usuarios_id = usuarios_id;
	}

	public String getNiveljugador() {
		return niveljugador;
	}

	public void setNiveljugador(String niveljugador) {
		this.niveljugador = niveljugador;
	}

	public int getTotalpartidas() {
		return totalpartidas;
	}

	public void setTotalpartidas(int totalpartidas) {
		this.totalpartidas = totalpartidas;
	}

	public int getPartidasganadas() {
		return partidasganadas;
	}

	public void setPartidasganadas(int partidasganadas) {
		this.partidasganadas = partidasganadas;
	}

	public int getPartidasperdidas() {
		return partidasperdidas;
	}

	public void setPartidasperdidas(int partidasperdidas) {
		this.partidasperdidas = partidasperdidas;
	}

	public float getPorcentajevictorias() {
		return porcentajevictorias;
	}

	public void setPorcentajevictorias(float porcentajevictorias) {
		this.porcentajevictorias = porcentajevictorias;
	}
	
	
	
}
