package dataModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServicePago implements ServicePagoLocal{
	
	private EntityManagerFactory emf;
	
	public ServicePago() {
		emf = Persistence.createEntityManagerFactory("EjemploEE01");
	}
	@Override
	public String insertarPago(Pagos pago) {
		System.out.println("funcion insertarPago");
		System.out.println("voy a generar pago con id: "+ pago.getIdpago());
		EntityManager em = emf.createEntityManager();
		try {
			Pagos e = em.find(Pagos.class, pago.getIdpago());
			if (e == null) {
				
				em.persist(pago);
				System.out.println("inserte pago");
				
				return "insertado";
			}
			else
				return "existe";
		}finally {
			em.close();
		}
	}

}
