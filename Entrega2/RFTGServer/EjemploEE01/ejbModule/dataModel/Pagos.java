package dataModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Pagos")
@NamedQuery(name="Pagos.findAll", query="SELECT p FROM Pagos p")
public class Pagos implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private int idpago;
	
	private int usuarios_id;
	
	private String entidadbancaria;
	
	private int valorcompra;
	
	private String articulocomprado;
	
	private int cantidad;
	
	

	public Pagos() {
		
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public int getIdpago() {
		return idpago;
	}

	public void setIdpago(int idpago) {
		this.idpago = idpago;
	}

	public int getUsuarios_id() {
		return usuarios_id;
	}

	public void setUsuarios_id(int usuarios_id) {
		this.usuarios_id = usuarios_id;
	}

	public String getEntidadbancaria() {
		return entidadbancaria;
	}

	public void setEntidadbancaria(String entidadbancaria) {
		this.entidadbancaria = entidadbancaria;
	}

	public int getValorcompra() {
		return valorcompra;
	}

	public void setValorcompra(int valorcompra) {
		this.valorcompra = valorcompra;
	}

	public String getArticulocomprado() {
		return articulocomprado;
	}

	public void setArticulocomprado(String articulocomprado) {
		this.articulocomprado = articulocomprado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
