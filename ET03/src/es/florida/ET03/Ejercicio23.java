/**
 * Crea otra funcionalidad que permita a un usuario introducir objetos nuevos en la lista. Para ello se le deben pedir los valores de los atributos, posteriormente crear un objeto con dichos atributos y, finalmente, añadir el objeto a la lista.
 */
package es.florida.ET03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio23 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(new File("peliculas.xml"));
		Element raiz = document.getDocumentElement();
		System.out.println("Contenido XML " + raiz.getNodeName() + ":");
		NodeList nodeList = document.getElementsByTagName("Pelicula");
		int numeroNodos = nodeList.getLength();
		System.out.println("Numero total de nodos (peliculas): " + numeroNodos);
		ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>(); // Opcion 2: Guardar como Lista (tamaño no
																		// predefinido)
		for (int i = 0; i < numeroNodos; i++) {
			Node nodo = nodeList.item(i);
			Element elemento = (Element) nodo;
			String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
			String director = elemento.getElementsByTagName("Director").item(0).getTextContent();
			String puntuacion = elemento.getElementsByTagName("Puntuacion").item(0).getTextContent();
			String genero = elemento.getElementsByTagName("Genero").item(0).getTextContent();
			Pelicula nuevaPelicula = new Pelicula(titulo, director, puntuacion, genero);
			listaPeliculas.add(nuevaPelicula);
			System.out.println("Pelicula guardada en lista: " + nuevaPelicula.toString());
		}

		System.out.print("Añadir nueva pelicula (s/n): ");
		Scanner teclado = new Scanner(System.in);
		String respuesta = teclado.nextLine();
		while (respuesta.equals("s")) {
			System.out.print("Titulo: ");
			String titulo = teclado.nextLine();
			System.out.print("Director: ");
			String director = teclado.nextLine();
			System.out.print("Puntuacion: ");
			String puntuacion = teclado.nextLine();
			System.out.print("Genero: ");
			String genero = teclado.nextLine();
			Pelicula nuevaPelicula = new Pelicula(titulo, director, puntuacion, genero);
			listaPeliculas.add(nuevaPelicula);
			System.out.println("Pelicula guardada en lista: " + nuevaPelicula.toString());
			System.out.print("Añadir nueva pelicula (s/n): ");
			respuesta = teclado.nextLine();
		}
		teclado.close();
	}
}
