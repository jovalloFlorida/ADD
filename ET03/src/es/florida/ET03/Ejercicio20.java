/**
 * Amplía el programa anterior para que además recorra los nodos uno a uno y muestre por pantalla sus atributos.
 */
package es.florida.ET03;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio20 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(new File("peliculas.xml"));
		Element raiz = document.getDocumentElement();
		System.out.println("Contenido XML " + raiz.getNodeName() + ":");
		NodeList nodeList = document.getElementsByTagName("Pelicula");
		System.out.println("Numero total de nodos (peliculas): " + nodeList.getLength());
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nodo = nodeList.item(i);
			Element elemento = (Element) nodo;
			System.out.println("");
			System.out.println("Titulo: " + elemento.getElementsByTagName("Titulo").item(0).getTextContent());
			System.out.println("Director: " + elemento.getElementsByTagName("Director").item(0).getTextContent());
			System.out.println("Puntuacion: " + elemento.getElementsByTagName("Puntuacion").item(0).getTextContent());
			System.out.println("Genero: " + elemento.getElementsByTagName("Genero").item(0).getTextContent());

		}

	}

}
