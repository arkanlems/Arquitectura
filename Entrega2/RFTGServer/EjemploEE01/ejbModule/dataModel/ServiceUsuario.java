package dataModel;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class ServiceUsuario
 */
@Stateless
@LocalBean
public class ServiceUsuario implements ServiceUsuarioLocal {

    private EntityManagerFactory emf;
	/**
	 * Default constructor.
	 */
	public ServiceUsuario() {
		// TODO Auto-generated constructor stub
		emf = Persistence.createEntityManagerFactory("EjemploEE01");
	}

	@Override
	public List<Usuario> findUsuario(String userName, String password) {
		EntityManager em = emf.createEntityManager();
		try {

			String consulta = "SELECT u FROM Usuario u WHERE u.userName=:userName AND u.password=:password";

			TypedQuery<Usuario> query = em.createQuery(consulta, Usuario.class);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			query.setMaxResults(1);

			List<Usuario> resultList = query.getResultList();

			return resultList;

		} finally {
			em.close();
		}
	}

	@Override
	public String insertarUsuario(Usuario usuario) {
		EntityManager em = emf.createEntityManager();
		try {
			Usuario user = em.find(Usuario.class, usuario.getIdusuario());
			if (user == null) {
				em.persist(usuario);
				return "insertado";
			}
			else
				return "existe";
		}finally {
			em.close();
		}
	}

	@Override
	public List<Usuario> findAllUsuarios() {
		EntityManager em = emf.createEntityManager();
		try {
		    return em.createQuery("SELECT p FROM Usuario p", Usuario.class).getResultList();
		}finally {
			em.close();
		}
	}

}
