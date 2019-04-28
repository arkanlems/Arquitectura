package dataModel;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class ServiceEstadisticas implements ServiceEstadisticasLocal {

	private EntityManagerFactory emf;
	
	public ServiceEstadisticas() {
		emf = Persistence.createEntityManagerFactory("EjemploEE01");
	}
	
	public List<Estadisticas> findEstadistica(int id) {
		EntityManager em = emf.createEntityManager();
		try {

			String consulta = "SELECT e FROM Estadisticas e WHERE e.usuarios_id = ?1 ";

			TypedQuery<Estadisticas> query = em.createQuery(consulta, Estadisticas.class);
			query.setParameter(1, id);
			query.setMaxResults(1);

			List<Estadisticas> resultList = query.getResultList();
			
			System.out.println("getResult executed");
			
			return resultList;

		} finally {
			em.close();
		}
	}

	@Override
	public String insertarEstadistica(Estadisticas est) {
		System.out.println("funcion insertarEstaditica");
		EntityManager em = emf.createEntityManager();
		try {
			Estadisticas e = em.find(Estadisticas.class, est.getUsuarios_id());
			if (e == null) {
				est.setNiveljugador("principiante");
				est.setPartidasganadas(0);
				est.setPartidasperdidas(0);
				est.setPorcentajevictorias(0.0f);
				est.setTotalpartidas(0);
				em.persist(est);
				System.out.println("inserte la estadistica");
				
				return "insertado";
			}
			else
				return "existe";
		}finally {
			em.close();
		}
	}

	@Override
	public List<Estadisticas> findAllEstadisticas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
