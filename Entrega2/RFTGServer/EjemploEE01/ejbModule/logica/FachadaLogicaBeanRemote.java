package logica;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import dataModel.articulo;
import dataModel.Estadisticas;
import dataModel.Usuario;

@Remote
public interface FachadaLogicaBeanRemote {
	
	public Usuario findUsuario(String userName, String password);
	public String insertarUsuario(Usuario usuario);
	public String actualizarUsuario(Usuario usuario);
	public List<Usuario> findAllUsuarios();	
	public Estadisticas findEstadisticas(int id);
	public String insertarEstadisticas(Estadisticas estadisticas);
	public List<articulo> getTienda() throws ParserConfigurationException, SAXException;
	public String actualizarInventario(List<articulo> stock);
	
}
