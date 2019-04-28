package dataModel;

import java.util.List;

import javax.ejb.Local;
@Local
public interface ServiceEstadisticasLocal {

	public List<Usuario> findEstadistica(int id);
	
	public String insertarEstadistica(Estadisticas usuario);
	
	public List<Usuario> findAllEstadisticas();	
}
