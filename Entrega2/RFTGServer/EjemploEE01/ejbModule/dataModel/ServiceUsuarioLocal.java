package dataModel;


import java.util.List;

import javax.ejb.Local;

@Local
public interface ServiceUsuarioLocal {

	public List<Usuario> findUsuario(String userName, String password);
	
	public String insertarUsuario(Usuario usuario);
	
	public List<Usuario> findAllUsuarios();

	public String actualizarUsuario(Usuario usuario);	
		
}
