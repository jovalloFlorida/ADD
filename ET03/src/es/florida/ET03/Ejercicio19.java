/**
 * Crea un programa que implemente un parser para gestionar el fichero XML y devuelva por pantalla el número de nodos (objetos) que haya en el fichero.
 */
package es.florida.ET03;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio19 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(new File("peliculas.xml"));
		Element raiz = document.getDocumentElement();
		System.out.println("Contenido XML " + raiz.getNodeName() + ":");
		NodeList nodeList = document.getElementsByTagName("Pelicula");
		System.out.println("Numero total de nodos (peliculas): " + nodeList.getLength());

	}

}
