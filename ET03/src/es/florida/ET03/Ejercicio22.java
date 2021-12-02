/**
 * Para probar que el objeto funciona correctamente, realizamos otra modificación que implemente que a medida que se lean los nodos del XML se vayan creando objetos y guardándolos en una lista.
 */
package es.florida.ET03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio22 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(new File("peliculas.xml"));
		Element raiz = document.getDocumentElement();
		System.out.println("Contenido XML " + raiz.getNodeName() + ":");
		NodeList nodeList = document.getElementsByTagName("Pelicula");
		int numeroNodos = nodeList.getLength();
		System.out.println("Numero total de nodos (peliculas): " + numeroNodos);
		Pelicula[] arrayPeliculas = new Pelicula[numeroNodos]; // Opcion 1: Guardar como Array (tamaño fijo predefinido)
		ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>(); // Opcion 2: Guardar como Lista (tamaño no
																		// predefinido)
		for (int i = 0; i < numeroNodos; i++) {
			Node nodo = nodeList.item(i);
			Element elemento = (Element) nodo;
			String titulo= elemento.getElementsByTagName("Titulo").item(0).getTextContent();
			String director = elemento.getElementsByTagName("Director").item(0).getTextContent();
			String puntuacion = elemento.getElementsByTagName("Puntuacion").item(0).getTextContent();
			String genero = elemento.getElementsByTagName("Genero").item(0).getTextContent();
			System.out.println("");
			System.out.println("Titulo: " + elemento.getElementsByTagName("Titulo").item(0).getTextContent());
			System.out.println("Director: " + elemento.getElementsByTagName("Director").item(0).getTextContent());
			System.out.println("Puntuacion: " + elemento.getElementsByTagName("Puntuacion").item(0).getTextContent());
			System.out.println("Genero: " + elemento.getElementsByTagName("Genero").item(0).getTextContent());
			System.out.println("");
			System.out.println("Titulo: " + titulo);
			System.out.println("Director: " + director);
			System.out.println("Puntuacion: " + puntuacion);
			System.out.println("Genero: " + genero);
			Pelicula nuevaPelicula = new Pelicula(titulo, director, puntuacion, genero);
			arrayPeliculas[i] = nuevaPelicula;
			listaPeliculas.add(nuevaPelicula);
			System.out.println("Pelicula creada: " + nuevaPelicula.toString());

		}

	}

}
