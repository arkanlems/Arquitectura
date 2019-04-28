package dataModel;

import java.util.List;

import javax.ejb.Local;
@Local
public interface ServiceEstadisticasLocal {

	public List<Estadisticas> findEstadistica(int id);
	
	public String insertarEstadistica(Estadisticas estadisticas);
	
	public List<Estadisticas> findAllEstadisticas();	
}
