package cliente;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fachada.PrimerServicio;
import fachada.PrimerServicioRemote;

public class LocalizadorServicios {

	public PrimerServicioRemote getRemoteFachadaLogica() throws NamingException {
		return this.lookupFachadaLogicaBean("ejb:");
	}

	private PrimerServicioRemote lookupFachadaLogicaBean(String namespace) throws NamingException {
		Context ctx = createInitialContext();
		String appName = "";
		String moduleName = "ProyectoEJB2";
		String distinctName = "";
		String beanName = PrimerServicio.class.getSimpleName();
		String viewClassName = PrimerServicioRemote.class.getName();
		return (PrimerServicioRemote) ctx.lookup(
				namespace + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
	}

	private static Context createInitialContext() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8090");
		jndiProperties.put(Context.SECURITY_PRINCIPAL, "test");
		jndiProperties.put(Context.SECURITY_CREDENTIALS, "123");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		return new InitialContext(jndiProperties);
	}

}
