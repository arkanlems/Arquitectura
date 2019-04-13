package controlador;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import logica.FachadaLogicaBean;
import logica.FachadaLogicaBeanRemote;

public class LocalizadorServicios {

	public LocalizadorServicios() {
		// TODO Auto-generated constructor stub
	}
	
	public FachadaLogicaBeanRemote getServicio1(){
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8090");
		jndiProperties.put(Context.SECURITY_PRINCIPAL, "test");
		jndiProperties.put(Context.SECURITY_CREDENTIALS, "tester1*");
		jndiProperties.put("jboss.naming.client.ejb.context", true);	
		
		Context ctx;
		String namespace = "ejb:";
		String appName = "";
		String moduleName = "EjemploEE01";
		String distinctName = "";
		String beanName = FachadaLogicaBean.class.getSimpleName();
		String viewClassName = FachadaLogicaBeanRemote.class.getName();
		
		FachadaLogicaBeanRemote fachadaLogica = null;
		
		try {
			ctx = new InitialContext(jndiProperties);
			
			fachadaLogica = (FachadaLogicaBeanRemote) ctx.lookup(
					namespace + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return fachadaLogica;
	}

}
