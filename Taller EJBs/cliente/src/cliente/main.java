package cliente;

import javax.naming.NamingException;

import fachada.PrimerServicio;
import fachada.PrimerServicioRemote;
public class main {

	public static void main(String[] args) {
		
			// TODO Auto-generated method stub
			 LocalizadorServicios serviceLocator = new LocalizadorServicios();
			 PrimerServicioRemote fachadaLogica = null;
			try {
			fachadaLogica = serviceLocator.getRemoteFachadaLogica();
			} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			 System.out.println(fachadaLogica.Servicio01Remote("Servicio01Remote"));
			}

}
