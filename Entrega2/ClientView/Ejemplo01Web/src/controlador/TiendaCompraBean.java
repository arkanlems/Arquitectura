package controlador;

public class TiendaCompraBean {

	private int uniqueid;
	
	private String nombre_articulo;
	
	private int und_disponibles;
	
	private String descripcion;
	
	public TiendaCompraBean() 
	{
	}

	public int getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(int uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getNombre_articulo() {
		return nombre_articulo;
	}

	public void setNombre_articulo(String nombre_articulo) {
		this.nombre_articulo = nombre_articulo;
	}

	public int getUnd_disponibles() {
		return und_disponibles;
	}

	public void setUnd_disponibles(int und_disponibles) {
		this.und_disponibles = und_disponibles;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
