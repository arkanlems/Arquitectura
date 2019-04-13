package fachada;

import javax.ejb.Remote;

@Remote
public interface PrimerServicioRemote {
	public String Servicio01Remote(String dato);
}
