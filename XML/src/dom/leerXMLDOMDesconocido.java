package dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class leerXMLDOMDesconocido {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File fichero = new File ("C:/dir1/concesionario.xml");

		DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc =   dBuilder.parse(fichero);

		doc.getDocumentElement().normalize();
		procesaNodo(doc.getDocumentElement());
	}
	public static void procesaNodo(Node nodo) {
		if(nodo.getNodeType() == Node.ELEMENT_NODE) {
			System.out.println("Elemento: "+ nodo.getNodeName());
			NamedNodeMap atributos = nodo.getAttributes();
			for (int i = 0; i < atributos.getLength(); i++) {
				Node atributo = atributos.item(i);
				System.out.println("Atributo: "+ atributo.getNodeName() + " Valor: " + atributo.getNodeValue());
			}
		}
		if(nodo.getNodeType() == Node.TEXT_NODE && !nodo.getTextContent().trim().isEmpty()) {
			System.out.println("Texto: "+ nodo.getTextContent());
		}
		NodeList nodosHijos = nodo.getChildNodes();
		for (int i = 0; i < nodosHijos.getLength(); i++) {
			procesaNodo(nodosHijos.item(i));
		}
	}
}
