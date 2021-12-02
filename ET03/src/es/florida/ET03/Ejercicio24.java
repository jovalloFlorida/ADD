/**
 * Como última funcionalidad, se pide que se guarde la lista completa de objetos en un nuevo fichero XML. Se debe comprobar que el formato del fichero resultante se corresponda al esperado para un fichero XML (indent o sangría adecuados).
 */
package es.florida.ET03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio24 {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
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

		System.out.println("Guardar lista de peliculas en 'peliculas2.xml'");
		// Preparar el DOM
		DocumentBuilderFactory dFac = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = dFac.newDocumentBuilder();
		Document doc = build.newDocument();
		Element nuevaRaiz = doc.createElement("Peliculas");
		doc.appendChild(nuevaRaiz);
		for (Pelicula pelicula : listaPeliculas) {
			Element elementoPelicula = doc.createElement("Pelicula");
			nuevaRaiz.appendChild(elementoPelicula);
			
			Element titulo = doc.createElement("Titulo");
			titulo.appendChild(doc.createTextNode(String.valueOf(pelicula.getTitulo())));
			elementoPelicula.appendChild(titulo);
			
			Element artista = doc.createElement("Director");
			artista.appendChild(doc.createTextNode(String.valueOf(pelicula.getDirector())));
			elementoPelicula.appendChild(artista);
			
			Element anyo = doc.createElement("Puntuacion");
			anyo.appendChild(doc.createTextNode(String.valueOf(pelicula.getPuntuacion())));
			elementoPelicula.appendChild(anyo);
			
			Element formato = doc.createElement("Genero");
			formato.appendChild(doc.createTextNode(String.valueOf(pelicula.getGenero())));
			elementoPelicula.appendChild(formato);
		}
		// Guardar el DOM en disco
		TransformerFactory tranFactory = TransformerFactory.newInstance();
		Transformer aTransformer = tranFactory.newTransformer();
		aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		FileWriter fw = new FileWriter("peliculas2.xml");
		StreamResult result = new StreamResult(fw);
		aTransformer.transform(source, result);
		fw.close();
	}
}
