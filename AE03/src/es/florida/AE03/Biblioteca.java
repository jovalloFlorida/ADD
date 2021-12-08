/**
 * Clase principal donde desarrollamos todas las funciones o metodos
 */
package es.florida.AE03;

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

public class Biblioteca {

	/**
	 * Metodo para Sacar por pantalla el Menu Principal
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws TransformerException
	 */
	public void menuPrincipal() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		
		try {
			System.out.println("\n\n");
			System.out.println("1. Mostrar todos los títulos de la biblioteca");
			System.out.println("2. Mostrar información detallada de un libro");
			System.out.println("3. Crear nuevo libro");
			System.out.println("4. Actualizar libro");
			System.out.println("5. Borrar libro");
			System.out.println("6. Cerrar la biblioteca\n");
			System.out.print("Eligen una Opcion del 1 al 6: ");
			Scanner teclado = new Scanner(System.in);
			String respuesta = teclado.nextLine();

			switch (respuesta) {
			case "1":
				recuperarTodos();
				break;
			case "2":
				mostrarLibro();
				break;
			case "3":
				crearLibro();
				break;
			case "4":
				actualizaLibro();
				break;
			case "5":
				borrarLibro();
				break;
			case "6":
				System.out.println("\nSalida de la Aplicacion");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}

			teclado.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Metodo para devolver una lista con todos los libros de la biblioteca (fichero
	 * .xml).
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws TransformerException
	 */
	public void recuperarTodos() throws ParserConfigurationException, SAXException, IOException, TransformerException {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("Libros.xml"));
			NodeList nodeList = document.getElementsByTagName("Libro");
			int numeroNodos = nodeList.getLength();
			ArrayList<Libro> listaLibro = new ArrayList<Libro>();

			for (int i = 0; i < numeroNodos; i++) {
				Node nodo = nodeList.item(i);
				Element elemento = (Element) nodo;
				String identificador = elemento.getElementsByTagName("Identificador").item(0).getTextContent();
				String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
				String autor = elemento.getElementsByTagName("Autor").item(0).getTextContent();
				String aPublicacion = elemento.getElementsByTagName("Publicacion").item(0).getTextContent();
				String editorial = elemento.getElementsByTagName("Editorial").item(0).getTextContent();
				String numPaginas = elemento.getElementsByTagName("NumPaginas").item(0).getTextContent();
				Libro nuevoLibro = new Libro(identificador, titulo, autor, aPublicacion, editorial, numPaginas);
				listaLibro.add(nuevoLibro);
				System.out.println("\nDatos del Libro " + "\nIdentificador: " + identificador + "\nTitulo: " + titulo);

			}

			System.out.print("\nQuieres hacer otra operacion (s/n): ");
			Scanner nuevaOperacion = new Scanner(System.in);
			String respuesta = nuevaOperacion.nextLine();
			if (respuesta.equals("s"))
				menuPrincipal();
			nuevaOperacion.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Metodo para mostrar el libro a partir de la introduccion de un identificador
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws TransformerException
	 */
	public void mostrarLibro() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		System.out.print("Introduce el identificador del Libro a mostrar la informacion: ");
		Scanner teclado = new Scanner(System.in);
		String idLibro = teclado.nextLine();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(new File("Libros.xml"));
		NodeList nodeList = document.getElementsByTagName("Libro");
		int numeroNodos = nodeList.getLength();
		ArrayList<Libro> listaLibro = new ArrayList<Libro>();

		for (int i = 0; i < numeroNodos; i++) {
			Node nodo = nodeList.item(i);
			Element elemento = (Element) nodo;
			String identificador = elemento.getElementsByTagName("Identificador").item(0).getTextContent();
			String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
			String autor = elemento.getElementsByTagName("Autor").item(0).getTextContent();
			String aPublicacion = elemento.getElementsByTagName("Publicacion").item(0).getTextContent();
			String editorial = elemento.getElementsByTagName("Editorial").item(0).getTextContent();
			String numPaginas = elemento.getElementsByTagName("NumPaginas").item(0).getTextContent();
			Libro nuevoLibro = new Libro(identificador, titulo, autor, aPublicacion, editorial, numPaginas);
			listaLibro.add(nuevoLibro);

			if (Integer.valueOf(idLibro) == Integer.valueOf(identificador)) {
				System.out.println("\nDatos del Libro " + nuevoLibro.toString());
			}

		}

		System.out.print("\nQuieres hacer otra operacion (s/n): ");
		Scanner nuevaOperacion = new Scanner(System.in);
		String respuesta = nuevaOperacion.nextLine();
		if (respuesta.equals("s"))
			menuPrincipal();
		nuevaOperacion.close();
		teclado.close();
	}

	/**
	 * Metodo para añadir libros a la biblioteca (fichero .xml)
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws TransformerException
	 */
	public void crearLibro() throws ParserConfigurationException, SAXException, IOException, TransformerException {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("Libros.xml"));
			NodeList nodeList = document.getElementsByTagName("Libro");
			int numeroNodos = nodeList.getLength();
			ArrayList<Libro> listaLibro = new ArrayList<Libro>();

			for (int i = 0; i < numeroNodos; i++) {
				Node nodo = nodeList.item(i);
				Element elemento = (Element) nodo;
				String identificador = elemento.getElementsByTagName("Identificador").item(0).getTextContent();
				String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
				String autor = elemento.getElementsByTagName("Autor").item(0).getTextContent();
				String aPublicacion = elemento.getElementsByTagName("Publicacion").item(0).getTextContent();
				String editorial = elemento.getElementsByTagName("Editorial").item(0).getTextContent();
				String numPaginas = elemento.getElementsByTagName("NumPaginas").item(0).getTextContent();
				Libro nuevoLibro = new Libro(identificador, titulo, autor, aPublicacion, editorial, numPaginas);
				listaLibro.add(nuevoLibro);

			}
			System.out.print("Añadir nuevo Libro (s/n): ");
			Scanner teclado = new Scanner(System.in);
			String respuesta = teclado.nextLine();
			while (respuesta.equals("s")) {
				String nuevoIdentificador = String.valueOf(numeroNodos + 1);
				System.out.print("Titulo: ");
				String nuevoTitulo = teclado.nextLine();
				System.out.print("Autor: ");
				String nuevoAutor = teclado.nextLine();
				System.out.print("Año de Publicacion: ");
				String nuevoaPublicacion = teclado.nextLine();
				System.out.print("Editorial: ");
				String nuevoEditorial = teclado.nextLine();
				System.out.print("Numero de Paginas: ");
				String nuevoNumPaginas = teclado.nextLine();
				Libro nuevosLibro = new Libro(nuevoIdentificador, nuevoTitulo, nuevoAutor, nuevoaPublicacion,
						nuevoEditorial, nuevoNumPaginas);
				listaLibro.add(nuevosLibro);
				System.out.print("Añadir nuevo libro (s/n): ");
				respuesta = teclado.nextLine();
			}
			//teclado.close();

			System.out.println("Guardando libros en 'Libro.xml'");
			// Preparar el DOM
			DocumentBuilderFactory dFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFac.newDocumentBuilder();
			Document doc = build.newDocument();
			Element nuevaRaiz = doc.createElement("Libros");
			doc.appendChild(nuevaRaiz);
			for (Libro libro : listaLibro) {
				Element elementoLibro = doc.createElement("Libro");
				nuevaRaiz.appendChild(elementoLibro);

				Element nuevoIdentificador = doc.createElement("Identificador");
				nuevoIdentificador.appendChild(doc.createTextNode(String.valueOf(libro.getIdentificador())));
				elementoLibro.appendChild(nuevoIdentificador);

				Element nuevoTitulo = doc.createElement("Titulo");
				nuevoTitulo.appendChild(doc.createTextNode(String.valueOf(libro.getTitulo())));
				elementoLibro.appendChild(nuevoTitulo);

				Element nuevoAutor = doc.createElement("Autor");
				nuevoAutor.appendChild(doc.createTextNode(String.valueOf(libro.getAutor())));
				elementoLibro.appendChild(nuevoAutor);

				Element nuevoaPublicacion = doc.createElement("Publicacion");
				nuevoaPublicacion.appendChild(doc.createTextNode(String.valueOf(libro.getaPublicacion())));
				elementoLibro.appendChild(nuevoaPublicacion);

				Element nuevoEditorial = doc.createElement("Editorial");
				nuevoEditorial.appendChild(doc.createTextNode(String.valueOf(libro.getEditorial())));
				elementoLibro.appendChild(nuevoEditorial);

				Element nuevoNumPaginas = doc.createElement("NumPaginas");
				nuevoNumPaginas.appendChild(doc.createTextNode(String.valueOf(libro.getnumPaginas())));
				elementoLibro.appendChild(nuevoNumPaginas);

			}
			// Guardar el DOM en disco
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			FileWriter fw = new FileWriter("Libros.xml");
			StreamResult result = new StreamResult(fw);
			aTransformer.transform(source, result);
			fw.close();

			System.out.print("\nQuieres hacer otra operacion (s/n): ");
			Scanner nuevaOperacion = new Scanner(System.in);
			String nuevaRespuesta = nuevaOperacion.nextLine();
			if (nuevaRespuesta.equals("s"))
				menuPrincipal();
			nuevaOperacion.close();
			teclado.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Metodo para actualizar los datos a partir de la introduccion de un
	 * identificador
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws TransformerException
	 */
	public void actualizaLibro() throws ParserConfigurationException, SAXException, IOException, TransformerException {

		try {
			System.out.print("Introduce el identificador del Libro a modificar la informacion: ");
			Scanner teclado = new Scanner(System.in);
			String idLibro = teclado.nextLine();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("Libros.xml"));
			NodeList nodeList = document.getElementsByTagName("Libro");
			int numeroNodos = nodeList.getLength();
			ArrayList<Libro> listaLibro = new ArrayList<Libro>();

			for (int i = 0; i < numeroNodos; i++) {
				Node nodo = nodeList.item(i);
				Element elemento = (Element) nodo;
				String identificador = elemento.getElementsByTagName("Identificador").item(0).getTextContent();
				String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
				String autor = elemento.getElementsByTagName("Autor").item(0).getTextContent();
				String aPublicacion = elemento.getElementsByTagName("Publicacion").item(0).getTextContent();
				String editorial = elemento.getElementsByTagName("Editorial").item(0).getTextContent();
				String numPaginas = elemento.getElementsByTagName("NumPaginas").item(0).getTextContent();

				if (Integer.valueOf(idLibro) == Integer.valueOf(identificador)) {
					Scanner tecladoADD = new Scanner(System.in);
					identificador = String.valueOf(idLibro);
					System.out.print("Titulo: ");
					titulo = tecladoADD.nextLine();
					System.out.print("Autor: ");
					autor = tecladoADD.nextLine();
					System.out.print("Año de Publicacion: ");
					aPublicacion = tecladoADD.nextLine();
					System.out.print("Editorial: ");
					editorial = tecladoADD.nextLine();
					System.out.print("Numero de Paginas: ");
					numPaginas = tecladoADD.nextLine();
					Libro nuevoLibro = new Libro(identificador, titulo, autor, aPublicacion, editorial, numPaginas);
					listaLibro.add(nuevoLibro);

				} else {
					Libro nuevoLibro = new Libro(identificador, titulo, autor, aPublicacion, editorial, numPaginas);
					listaLibro.add(nuevoLibro);
				}

			}
			
			System.out.println("Actualizando libros en 'Libro.xml'");
			// Preparar el DOM
			DocumentBuilderFactory dFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFac.newDocumentBuilder();
			Document doc = build.newDocument();
			Element nuevaRaiz = doc.createElement("Libros");
			doc.appendChild(nuevaRaiz);
			for (Libro libro : listaLibro) {
				Element elementoLibro = doc.createElement("Libro");
				nuevaRaiz.appendChild(elementoLibro);

				Element identificador = doc.createElement("Identificador");
				identificador.appendChild(doc.createTextNode(String.valueOf(libro.getIdentificador())));
				elementoLibro.appendChild(identificador);

				Element titulo = doc.createElement("Titulo");
				titulo.appendChild(doc.createTextNode(String.valueOf(libro.getTitulo())));
				elementoLibro.appendChild(titulo);

				Element autor = doc.createElement("Autor");
				autor.appendChild(doc.createTextNode(String.valueOf(libro.getAutor())));
				elementoLibro.appendChild(autor);

				Element aPublicacion = doc.createElement("Publicacion");
				aPublicacion.appendChild(doc.createTextNode(String.valueOf(libro.getaPublicacion())));
				elementoLibro.appendChild(aPublicacion);

				Element editorial = doc.createElement("Editorial");
				editorial.appendChild(doc.createTextNode(String.valueOf(libro.getEditorial())));
				elementoLibro.appendChild(editorial);

				Element numPaginas = doc.createElement("NumPaginas");
				numPaginas.appendChild(doc.createTextNode(String.valueOf(libro.getnumPaginas())));
				elementoLibro.appendChild(numPaginas);

			}
			// Guardar el DOM en disco
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			FileWriter fw = new FileWriter("Libros.xml");
			StreamResult result = new StreamResult(fw);
			aTransformer.transform(source, result);
			fw.close();

			System.out.print("\nQuieres hacer otra operacion (s/n): ");
			Scanner nuevaOperacion = new Scanner(System.in);
			String respuesta = nuevaOperacion.nextLine();
			if (respuesta.equals("s"))
				menuPrincipal();
			nuevaOperacion.close();
			teclado.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Metodo para borrar un libro de la biblioteca (fichero .xml) a partir de la
	 * introduccion de un identificador
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws TransformerException
	 */
	public void borrarLibro() throws ParserConfigurationException, SAXException, IOException, TransformerException {

		try {
			System.out.print("Introduce el identificador del Libro a eliminar: ");
			Scanner teclado = new Scanner(System.in);
			String idLibro = teclado.nextLine();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("Libros.xml"));
			NodeList nodeList = document.getElementsByTagName("Libro");
			int numeroNodos = nodeList.getLength();
			ArrayList<Libro> listaLibro = new ArrayList<Libro>();

			for (int i = 0; i < numeroNodos; i++) {
				Node nodo = nodeList.item(i);
				Element elemento = (Element) nodo;
				String identificador = elemento.getElementsByTagName("Identificador").item(0).getTextContent();
				String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
				String autor = elemento.getElementsByTagName("Autor").item(0).getTextContent();
				String aPublicacion = elemento.getElementsByTagName("Publicacion").item(0).getTextContent();
				String editorial = elemento.getElementsByTagName("Editorial").item(0).getTextContent();
				String numPaginas = elemento.getElementsByTagName("NumPaginas").item(0).getTextContent();

				if (Integer.valueOf(idLibro) != Integer.valueOf(identificador)) {
					if (Integer.valueOf(identificador) == 1) {
						identificador = String.valueOf(1);
					} else {
						identificador = String.valueOf(Integer.valueOf(identificador) - 1);
					}
					Libro nuevoLibro = new Libro(identificador, titulo, autor, aPublicacion, editorial, numPaginas);
					listaLibro.add(nuevoLibro);

				}

			}
			

			System.out.println("Libro eliminado, Actualizando libros en 'Libro2.xml'");
			// Preparar el DOM
			DocumentBuilderFactory dFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFac.newDocumentBuilder();
			Document doc = build.newDocument();
			Element nuevaRaiz = doc.createElement("Libros");
			doc.appendChild(nuevaRaiz);
			for (Libro libro : listaLibro) {
				Element elementoLibro = doc.createElement("Libro");
				nuevaRaiz.appendChild(elementoLibro);

				Element identificador = doc.createElement("Identificador");
				identificador.appendChild(doc.createTextNode(String.valueOf(libro.getIdentificador())));
				elementoLibro.appendChild(identificador);

				Element titulo = doc.createElement("Titulo");
				titulo.appendChild(doc.createTextNode(String.valueOf(libro.getTitulo())));
				elementoLibro.appendChild(titulo);

				Element autor = doc.createElement("Autor");
				autor.appendChild(doc.createTextNode(String.valueOf(libro.getAutor())));
				elementoLibro.appendChild(autor);

				Element aPublicacion = doc.createElement("Publicacion");
				aPublicacion.appendChild(doc.createTextNode(String.valueOf(libro.getaPublicacion())));
				elementoLibro.appendChild(aPublicacion);

				Element editorial = doc.createElement("Editorial");
				editorial.appendChild(doc.createTextNode(String.valueOf(libro.getEditorial())));
				elementoLibro.appendChild(editorial);

				Element numPaginas = doc.createElement("NumPaginas");
				numPaginas.appendChild(doc.createTextNode(String.valueOf(libro.getnumPaginas())));
				elementoLibro.appendChild(numPaginas);

			}
			// Guardar el DOM en disco
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			FileWriter fw = new FileWriter("Libros.xml");
			StreamResult result = new StreamResult(fw);
			aTransformer.transform(source, result);
			fw.close();

			System.out.print("\nQuieres hacer otra operacion (s/n): ");
			Scanner nuevaOperacion = new Scanner(System.in);
			String respuesta = nuevaOperacion.nextLine();
			if (respuesta.equals("s"))
				menuPrincipal();
			nuevaOperacion.close();
			teclado.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
