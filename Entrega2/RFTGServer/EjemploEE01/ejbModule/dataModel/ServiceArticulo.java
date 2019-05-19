package dataModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class ServiceArticulo implements ServiceArticulosLocal {

	public ServiceArticulo() {
		
	}
	
	public List<articulo> getArticulos() throws ParserConfigurationException,
	SAXException{
		try {

			URL url = new URL( "http://localhost:58633/api/Articulos");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				    + conn.getResponseCode());
		   }
		
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			
			List <articulo> ar = new ArrayList<> ();
			System.out.println("Output from server ..... \n");
			while ((output = br.readLine()) != null) {
				System.out.println("12132312");
				System.err.println(output);

				DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				InputSource is = new InputSource();
				is.setCharacterStream(new StringReader(output));

				Document doc = db.parse(is);
				NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("articulo");
				
				for (int i = 0; i < nodes.getLength(); i++) {
				    articulo a = new articulo();
				    Element element = (Element) nodes.item(i);
				    //------------------
				    NodeList description =  element.getElementsByTagName("descripcion");
				    Element element2 = (Element) description.item(0);

				    a.setDescripcion(getCharacterDataFromElement(element2));
				    
				    //------------------
				    NodeList name = element.getElementsByTagName("nombre_articulo");
				    element2 = (Element) name.item(0);

				    a.setNombre_articulo(getCharacterDataFromElement(element2));
				    
				    //------------------
				    NodeList stock = element.getElementsByTagName("und_disponibles");
				    element2 = (Element) stock.item(0);

				    a.setUnd_disponibles(Integer.valueOf(getCharacterDataFromElement(element2)));

				    //----------------
				    NodeList id = element.getElementsByTagName("uniqueid");
				    element2 = (Element) id.item(0);

				    a.setUnd_disponibles(Integer.valueOf(getCharacterDataFromElement(element2)));

				    
				    ar.add(a);
				}
										
				}

			for (articulo articulo : ar) {
				System.out.println(articulo.getNombre_articulo());
			}
			conn.disconnect();
			return ar;
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		return null;

	}
	
	public static String getCharacterDataFromElement(Element e) {
		Node child = ((Node) e).getFirstChild();
		if (child instanceof CharacterData) {
		CharacterData cd = (CharacterData) child;
		return cd.getData();
		}
		return "";
		}

	public String updateArticulos(List<articulo> ar) {
		// TODO Auto-generated method stub
		return null;
	}

}
