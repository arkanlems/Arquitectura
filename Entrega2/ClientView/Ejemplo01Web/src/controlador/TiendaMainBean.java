package controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dataModel.articulo;

@ManagedBean
public class TiendaMainBean {
	public int cant_1;
	public int cant_2;
	public int cant_3;
	public int cant_4;
	public int cant_5;

	public TiendaMainBean() {
		
	}

	public int getCant_1() {
		return cant_1;
	}

	public void setCant_1(int cant_1) {
		this.cant_1 = cant_1;
	}

	public int getCant_2() {
		return cant_2;
	}

	public void setCant_2(int cant_2) {
		this.cant_2 = cant_2;
	}

	public int getCant_3() {
		return cant_3;
	}

	public void setCant_3(int cant_3) {
		this.cant_3 = cant_3;
	}

	public int getCant_4() {
		return cant_4;
	}

	public void setCant_4(int cant_4) {
		this.cant_4 = cant_4;
	}

	public int getCant_5() {
		return cant_5;
	}

	public void setCant_5(int cant_5) {
		this.cant_5 = cant_5;
	}


}
