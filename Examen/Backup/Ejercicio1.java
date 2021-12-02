package es.florida.Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Examen {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub

		//Ejercicio1
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(new File("config.xml"));
		Element raiz = document.getDocumentElement();
		System.out.println("Contenido XML " + raiz.getNodeName() + ":");
		NodeList nodeList = document.getElementsByTagName("config1");
		System.out.println("Numero total de nodos (configurations): " + nodeList.getLength());
		
		
		Node nodo = nodeList.item(0);
		Element elemento = (Element) nodo;
		String urlXML= elemento.getElementsByTagName("url").item(0).getTextContent();
		String userXML= elemento.getElementsByTagName("user").item(0).getTextContent();
		String passwdXML= elemento.getElementsByTagName("password").item(0).getTextContent();
		
		System.out.println("url: " + urlXML);
		System.out.println("user: " + userXML);
		System.out.println("password: " + passwdXML);
		
		//Ejericio2
		
	
		
	}


}
