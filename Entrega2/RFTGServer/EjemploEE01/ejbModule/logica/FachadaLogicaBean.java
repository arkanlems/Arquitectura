package logica;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import dataModel.ServiceUsuario;
import dataModel.ServiceUsuarioLocal;
import dataModel.Usuario;

/**
 * Session Bean implementation class FachadaLogicaBean
 */
@Stateless
@Remote(FachadaLogicaBeanRemote.class)
public class FachadaLogicaBean implements FachadaLogicaBeanRemote {

    /**
     * Default constructor. 
     */
    public FachadaLogicaBean() {
        // TODO Auto-generated constructor stub
    }
    
	//------------------------------------------------------------------------------    
	public Usuario findUsuario(String userName, String password) {
    	ServiceUsuarioLocal x = new ServiceUsuario();
    	
    	List<Usuario> usuarios = (List<Usuario>) x.findUsuario(userName, password);
    	
    	if (usuarios == null || usuarios.isEmpty())
    		return null;
    	
    	Usuario usuario = (Usuario) usuarios.get(0);
    	
    	System.out.println(usuario.getApellidos() + " " + usuario.getNombres());
    	
    	return usuario;
	}
	
	//------------------------------------------------------------------------------
	public String insertarUsuario(Usuario usuario) {
    	ServiceUsuarioLocal x = new ServiceUsuario();
    	
    	return x.insertarUsuario(usuario);
	}

	@Override
	public List<Usuario> findAllUsuarios() {
    	ServiceUsuarioLocal x = new ServiceUsuario();
    	
    	return x.findAllUsuarios();
	}
	
	//------------------------------------------------------------------------------	

}
