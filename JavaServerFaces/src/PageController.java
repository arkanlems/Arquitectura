import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PageController {

	@ManagedProperty("#{helloBean}")
	private HelloBean myBean;
	private String nombre;

	public HelloBean getMyBean() {
		return myBean;
	}

	public void setMyBean(HelloBean myBean) {
		this.nombre = myBean.getName();
		this.myBean = myBean;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String processPage1() {
		System.out.println("Hola PAGINA1:  " + nombre);
		return "success";
	}

	public String processPage2() {
		System.out.println("Hola PAGINA2:  " + nombre);
		return "success";
	}
}