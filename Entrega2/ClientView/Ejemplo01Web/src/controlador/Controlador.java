package controlador;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import controlador.LocalizadorServicios;
import controlador.LoginUsuariosBean;
import dataModel.Estadisticas;
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
	
	@EJB
	public Estadisticas estadisticas;
	
	@EJB
	public Estadisticas nuevaEst;
	
	public List<Usuario> listaUsuarios;	

	public Controlador() {
		// TODO Auto-generated constructor stub
		this.nuevoUsuario = new Usuario();
		this.nuevaEst = new Estadisticas();
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

		System.out.println("Solicitud recibida: " + nuevoUsuario.getid() + " " + nuevoUsuario.getNombres() + " "
				+ nuevoUsuario.getApellidos() + " " + nuevoUsuario.getusuario() + " " + nuevoUsuario.getcontrasenia());
		
		// Invoca el servicio remoto (retorna exito o existe)
		String result = fachadaLogica.insertarUsuario(nuevoUsuario);
		Usuario aux = fachadaLogica.findUsuario(nuevoUsuario.getusuario(), nuevoUsuario.getcontrasenia());
		if(aux != null) {
			System.out.println("no estoy vacio ñero"+aux.getid());
		}
		System.out.println("voy a asignar id");
		nuevaEst.setUsuarios_id(aux.getid());
		System.out.println("asigne id");
		
		
		return  fachadaLogica.insertarEstadisticas(nuevaEst);
		
		

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
