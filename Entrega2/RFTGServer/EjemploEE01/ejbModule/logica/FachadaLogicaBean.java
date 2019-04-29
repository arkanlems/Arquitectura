package logica;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import dataModel.Estadisticas;
import dataModel.ServiceEstadisticas;
import dataModel.ServiceEstadisticasLocal;
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
    	
    	System.out.println("oli en find usuario");
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

	@Override
	public Estadisticas findEstadisticas(int id) {
		ServiceEstadisticasLocal x = new ServiceEstadisticas();
    	
    	List<Estadisticas> estadisticas = (List<Estadisticas>) x.findEstadistica(id);
    	
    	if (estadisticas == null || estadisticas.isEmpty())
    		return null;
    	
    	System.out.println("oli en ");
    	Estadisticas estadistica = (Estadisticas) estadisticas.get(0);
    	
    	System.out.println("se encontro las estadisticas del usuario id: "+estadistica.getUsuarios_id());
    	
    	return estadistica;
	}

	public String insertarEstadisticas(Estadisticas estadisticas) {
		ServiceEstadisticasLocal x = new ServiceEstadisticas();
    	System.out.println("entre a insertarEstadisticas");
    	return x.insertarEstadistica(estadisticas);
	}

	@Override
	public String actualizarUsuario(Usuario usuario) {
		ServiceUsuarioLocal x = new ServiceUsuario();
    	System.out.println("estoy en actulizarUsuariod de fachada");
    	return x.actualizarUsuario(usuario);

	}
	
	//------------------------------------------------------------------------------	

}
