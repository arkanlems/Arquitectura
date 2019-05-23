package dataModel;

import java.net.MalformedURLException;
import java.util.List;

import javax.ejb.Local;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

@Local
public interface ServiceArticulosLocal {

	public List<articulo> getArticulos() throws ParserConfigurationException, SAXException;
	public String updateArticulos (List<articulo> ar) throws MalformedURLException;
}
