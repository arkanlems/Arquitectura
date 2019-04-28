package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import dataModel.Usuario;
import logica.FachadaLogicaBeanRemote;

@ManagedBean(eager = true)
@RequestScoped
public class Controlador {
	@ManagedProperty(value = "#{loginUsuariosBean}")
	public LoginUsuariosBean loginUsuario;
	
	@EJB
	public Usuario usuario;

	@EJB
	public Usuario nuevoUsuario;
	
	public List<Usuario> listaUsuarios;	

	public Controlador() {
		// TODO Auto-generated constructor stub
		this.nuevoUsuario = new Usuario();
		this.listaUsuarios = new ArrayList<Usuario>();
	}

	public String validarUsuario() {
		String userName = loginUsuario.getUserName();
		String password = loginUsuario.getPassword();

		System.out.println("Solicitud recibida: " + userName + " " + password);

		// Invoca el localizador de servicios para obtener la fachada remota
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		FachadaLogicaBeanRemote fachadaLogica = localizadorServicios.getServicio1();

		// Invoca el servicio remoto
		usuario = fachadaLogica.findUsuario(userName, password);

		if (usuario == null)
			return "fracaso";

		System.out.println("Usuario: " + usuario.getNombres() + ", " + usuario.getApellidos());

		return "exito";

	}
	
	public String loginError() {
		return "reintentar";
	}
	
	public String loginExito() {
		return "aceptar";
	}
	
	public String insertarUsuario() {
		// Invoca el localizador de servicios para obtener la fachada remota
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		FachadaLogicaBeanRemote fachadaLogica = localizadorServicios.getServicio1();

		System.out.println("Solicitud recibida: " + nuevoUsuario.getIdusuario() + " " + nuevoUsuario.getNombres() + " "
				+ nuevoUsuario.getApellidos() + " " + nuevoUsuario.getUserName() + " " + nuevoUsuario.getPassword());

		// Invoca el servicio remoto (retorna exito o existe)
		return fachadaLogica.insertarUsuario(nuevoUsuario);

	}

	public String insertarError() {
		return "reintentar";
	}
	
	public String insertarExito() {
		return "aceptar";
	}
	
	public String listarUsuarios() {
		// Invoca el localizador de servicios para obtener la fachada remota
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		FachadaLogicaBeanRemote fachadaLogica = localizadorServicios.getServicio1();

		// Invoca el servicio remoto (retorna exito o existe)
		listaUsuarios = fachadaLogica.findAllUsuarios();
		return "exito";
	}
	
	public String listarExito() {
		return "aceptar";
	}	
	
	public LoginUsuariosBean getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(LoginUsuariosBean loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getNuevoUsuario() {
		return nuevoUsuario;
	}

	public void setNuevoUsuario(Usuario nuevoUsuario) {
		this.nuevoUsuario = nuevoUsuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}
