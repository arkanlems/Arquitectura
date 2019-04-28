package logica;

import java.util.List;

import javax.ejb.Remote;

import dataModel.Estadisticas;
import dataModel.Usuario;

@Remote
public interface FachadaLogicaBeanRemote {
	
	public Usuario findUsuario(String userName, String password);
	public String insertarUsuario(Usuario usuario);
	public List<Usuario> findAllUsuarios();	
	public Estadisticas findEstadisticas(int id);
	public String insertarEstadisticas(Estadisticas estadisticas);

}
