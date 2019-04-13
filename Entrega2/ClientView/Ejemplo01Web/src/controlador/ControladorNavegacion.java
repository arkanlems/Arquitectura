package controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "controladorNavegacion", eager = true)
@RequestScoped
public class ControladorNavegacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//this managed property will read value from request parameter pageId
	   @ManagedProperty(value = "#{param.pageId}")
	   private String pageId;

	   //condicional navigation based on pageId
	   //if pageId is 1 show page1.xhtml,
	   //if pageId is 2 show page2.xhtml
	   //else show home.xhtml
	   
	   public String showPage() {
	      if(pageId == null) {
	         return "index";
	      }
	      
	      if(pageId.equals("1")) {
	         return "ingreso";
	      }else if(pageId.equals("2")) {
	         return "adicionarUsuarios";
	      }else if(pageId.equals("3")) {
		     return "listadoUsuarios";
	      }else {
	         return "index";
	      }
	   }

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	}