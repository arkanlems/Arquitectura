package controlador;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import controlador.LocalizadorServicios;
import controlador.LoginUsuariosBean;
import dataModel.articulo;
import dataModel.Estadisticas;
import dataModel.Usuario;
import logica.FachadaLogicaBeanRemote;

@ManagedBean(eager = true)
@RequestScoped
public class Controlador {
	@ManagedProperty(value = "#{loginUsuariosBean}")
	public LoginUsuariosBean loginUsuario;
	
<<<<<<< HEAD
	@ManagedProperty(value = "#{tiendaMainBean}")
	public TiendaMainBean stock;
		
=======
	
	
>>>>>>> parent of 42f56bb... Consumo del api en tienda
	
	@EJB
	public Usuario usuario;

	@EJB
	public Usuario nuevoUsuario;
	
	@EJB
	public Usuario updateUsuario;
	
	@EJB
	public Estadisticas estadisticas;
	
	/*@EJB
	public articulo as;*/
	
	public List<articulo> articulos;

	
	@EJB
	public Estadisticas nuevaEst;
	
	public List<Usuario> listaUsuarios;	
	
	public String userName;
	
	public String password;

	public Controlador() {
		// TODO Auto-generated constructor stub
		this.usuario = new Usuario();
		this.updateUsuario = new Usuario();
		this.nuevoUsuario = new Usuario();
		this.nuevaEst = new Estadisticas();
		this.estadisticas = new Estadisticas();
		this.articulos = new ArrayList<>();
	    //this.as = new articulo();
		this.listaUsuarios = new ArrayList<Usuario>();
	}

	public String validarUsuario() {
		userName = loginUsuario.getUserName();
		password = loginUsuario.getPassword();

		System.out.println("Solicitud recibida: " + userName + " " + password);

		// Invoca el localizador de servicios para obtener la fachada remota
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		FachadaLogicaBeanRemote fachadaLogica = localizadorServicios.getServicio1();

		// Invoca el servicio remoto
		usuario = fachadaLogica.findUsuario(userName, password);
		updateUsuario = fachadaLogica.findUsuario(userName, password);
		estadisticas = fachadaLogica.findEstadisticas(usuario.getid());
		if (usuario == null)
			return "fracaso";

		System.out.println("Usuario: " + usuario.getNombres()+updateUsuario.getid() + ", " + usuario.getApellidos());

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
	public String actualizarUsuario() {
		 
		//System.out.println("entre a actualizarUsuario de id xdxd: "+usuario.getid()+updateUsuario.getid()+updateUsuario.getcontrasenia()+usuario.getNombres());
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		FachadaLogicaBeanRemote fachadaLogica = localizadorServicios.getServicio1();
		
		//this.updateUsuario = fachadaLogica.findUsuario(loginUsuario.getUserName(), loginUsuario.getPassword());
		
		// Invoca el servicio remoto (retorna exito o existe)
		updateUsuario = fachadaLogica.findUsuario(usuario.getusuario(), usuario.getcontrasenia());
		estadisticas = fachadaLogica.findEstadisticas(usuario.getid());
		
		updateUsuario.setApellidos(usuario.getApellidos());
		updateUsuario.setCelular(usuario.getCelular());
		updateUsuario.setCorreo(usuario.getCorreo());
		updateUsuario.setIdioma(usuario.getIdioma());
		updateUsuario.setNacionalidad(usuario.getNacionalidad());
		updateUsuario.setNombres(usuario.getNombres());
		
		
		String x =fachadaLogica.actualizarUsuario(this.updateUsuario);
		 System.out.println("resultado: "+x);
			
		return x;
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
	
	public Usuario getUpdateUsuario() {
		return updateUsuario;
	}

	public Estadisticas getEstadisticas() {
		return estadisticas;
	}

	public Estadisticas getNuevaEst() {
		return nuevaEst;
	}

	public String listarExito() {
		return "aceptar";
	}	
	
	public String verEstadisticas() {
		
		return "verEstadisticas";
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
	
<<<<<<< HEAD
	public List<articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<articulo> articulos) {
		this.articulos = articulos;
	}	
	
	public TiendaMainBean getStock() {
		return stock;
	}

	public void setStock(TiendaMainBean stock) {
		this.stock = stock;
	}

=======
>>>>>>> parent of 42f56bb... Consumo del api en tienda
	public String verTienda() throws ParserConfigurationException, SAXException {
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		FachadaLogicaBeanRemote fachadaLogica = localizadorServicios.getServicio1();
		
		this.articulos = fachadaLogica.getTienda();
		
		for (articulo articulo : articulos) {
			System.out.println(articulo.getNombre_articulo());
		}
		
		return "tienda";	
	}
	
	public String goBack() {
		return "back";
	}

	/*public articulo getAs() {
		return as;
	}

	public void setAs(articulo as) {
		this.as = as;
	}*/
	
	public String comprarPaquete() throws ParserConfigurationException, SAXException {
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		FachadaLogicaBeanRemote fachadaLogica = localizadorServicios.getServicio1();
		
		this.articulos = fachadaLogica.getTienda();
		
		articulos.get(0).setUnd_disponibles(articulos.get(0).getUnd_disponibles()-stock.getCant_1());
		articulos.get(1).setUnd_disponibles(articulos.get(1).getUnd_disponibles()-stock.getCant_2());
		articulos.get(2).setUnd_disponibles(articulos.get(2).getUnd_disponibles()-stock.getCant_3());
		articulos.get(3).setUnd_disponibles(articulos.get(3).getUnd_disponibles()-stock.getCant_4());
		articulos.get(4).setUnd_disponibles(articulos.get(4).getUnd_disponibles()-stock.getCant_5());
		
		String x = fachadaLogica.actualizarInventario(articulos);
		System.out.println(x);
		return "back";			
	}
}
