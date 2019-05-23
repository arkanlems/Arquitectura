import java.util.ArrayList;
import java.util.HashMap;

public class Card {
	
	private String nombre;
	private int costo;
	private int PV;
	private boolean esMilitar;
	private boolean esWindfall;
	private boolean enInvestigacion;
	private Card Bienes = null;
	
	private HashMap<Integer, String> poderes;

	
	
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getPV() {
		return PV;
	}

	public void setPV(int pV) {
		PV = pV;
	}

	public boolean isEsMilitar() {
		return esMilitar;
	}

	public void setEsMilitar(boolean esMilitar) {
		this.esMilitar = esMilitar;
	}

	public boolean isEsWindfall() {
		return esWindfall;
	}

	public void setEsWindfall(boolean esWindfall) {
		this.esWindfall = esWindfall;
	}

	public boolean isEnInvestigacion() {
		return enInvestigacion;
	}

	public void setEnInvestigacion(boolean enInvestigacion) {
		this.enInvestigacion = enInvestigacion;
	}

	public Card getBienes() {
		return Bienes;
	}

	public void setBienes(Card bienes) {
		Bienes = bienes;
	}

	public HashMap<Integer, String> getPoderes() {
		return poderes;
	}

	public void setPoderes(HashMap<Integer, String> poderes) {
		this.poderes = poderes;
	}
	

	@Override
	public String toString() {
		return "Card [nombre=" + nombre + ", costo=" + costo + ", PV=" + PV + ", esMilitar=" + esMilitar
				+ ", esWindfall=" + esWindfall + ", enInvestigacion=" + enInvestigacion + ", Bienes=" + Bienes
				+ ", poderes=" + poderes + "]";
	}

}