package fachada;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PrimerServicio
 */
@Stateless
@LocalBean
public class PrimerServicio implements PrimerServicioRemote {

    /**
     * Default constructor. 
     */
    public PrimerServicio() {
        // TODO Auto-generated constructor stub
    }

	public String Servicio01Remote(String dato) {
		// TODO Auto-generated method stub
		return "se invoco el servicio01"+ dato;
	}

}
