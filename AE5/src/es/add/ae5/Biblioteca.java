package es.add.ae5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class Biblioteca {

	// M�todo: mostrarBD
	// Descripci�n: recibe las session, instancia un objeto modelo de tipo libro y va recuper objetos 
	//	del mismo tipo de la BD. Los guarda en una lista y, a continuaci�n, los encadena en un string 
	//	para mostrarlos posteriormente por pantalla.
	// Par�metros de entrada: session (creada a trav�s de session factory en principal).
	// Par�metros de salida: string con los datos (libros) de la BD.
	public static String mostrarBD(Session session) {

		String linea = "";

		try {

			List<Libro> libros = new ArrayList<>();
			Query libro = session.createQuery("from Libro");
			libros = libro.list();

			for (Libro elemento : libros) {
				linea += elemento.getId() + " - " + elemento.getTitulo() + "\n";
			}

		} catch (Exception e) {
			linea = "ERROR en la conexi�n con la BD.";
		}

		return linea;
	}

	// M�todo: consultarLibro
	// Descripci�n: recupera un objeto de tipo Libro de la BD a partir de una id.
	// Par�metros de entrada: session (creada a trav�s de session factory en principal) e id de tipo int.
	// Par�metros de salida: string con los datos del dato (libro) consultado.
	public static String consultarLibro(Session session, int id) {

		String linea = "";

		// Recupero y leo un objeto a partir de su ID
		Libro libro = (Libro) session.get(Libro.class, id);

		if (libro == null) {
			System.err.println("\nERROR en la consulta. �ID no existe?");
		} else {
			linea += "ID: " + libro.getId() + " - T�tulo: " + libro.getTitulo() + " - Autor: " + libro.getAutor()
					+ " - A�o de nacimiento: " + libro.getAnyoNac() + " - A�o de publicaci�n: " + libro.getAnyoPub()
					+ " - Editorial: " + libro.getEditorial() + " - N� de p�ginas: " + libro.getPags() + "\n";
		}

		return linea;
	}

	// M�todo: borrarLibro
	// Descripci�n: recupera un objeto de tipo Libro de la BD a partir de una id y lo borra.
	// Par�metros de entrada: session (creada a trav�s de session factory en principal) e id de tipo int.
	// Par�metros de salida: string que confirma el borrado.
	public static String borrarLibro(Session session, int id) {
		String linea = "";

		try {

			Libro libro = (Libro) session.get(Libro.class, id);

			if (libro != null) {
				libro.setId(id);
				session.delete(libro);
				linea += "\nLibro borrado correctamente. Fila: " + id;
			} else {
				linea += "\nNo existen registros con ID: " + id;
			}

		} catch (Exception e) {
			linea = "\nERROR en el borrado.";
		}

		return linea;
	}

	// M�todo: anyadirLibro
	// Descripci�n: crea un objeto de tipo libro y lo guarda en la BD con una nueva id.
	// Par�metros de entrada: session (creada a trav�s de session factory en principal) y strings.
	// Par�metros de salida: string que confirma el a�adido, mostrando los datos (libro) introducidos.
	public static String anyadirLibro(Session session, String titulo, String autor, String anyoNac, String anyoPub,
			String editorial, String pags) {

		String linea = "";

		try {

			// Crear nuevo objeto
			Libro libro = new Libro(titulo, autor, anyoNac, anyoPub, editorial, pags);
			Serializable id = session.save(libro);
			linea += "Libro a�adido --> ID: " + libro.getId() + " - T�tulo: " + libro.getTitulo() + " - Autor: "
					+ libro.getAutor() + " - A�o de nacimiento: " + libro.getAnyoNac() + " - A�o de publicaci�n: "
					+ libro.getAnyoPub() + " - Editorial: " + libro.getEditorial() + " - N� de p�ginas: "
					+ libro.getPags() + "\n";

		} catch (Exception e) {
			linea = "\nERROR en la inserci�n.";
		}

		return linea;

	}

	// M�todo: modificarLibro
	// Descripci�n: recupera un objeto de tipo Libro de la BD a partir de una id y modifica sus par�metros.
	// Par�metros de entrada: session (creada a trav�s de session factory en principal) y strings.
	// Par�metros de salida: String que confirma la modificaci�n, mostrando los datos (libro) modificados.
	public static String modificarLibro(Session session, int id, String titulo, String autor, String anyoNac,
			String anyoPub, String editorial, String pags) {

		String linea = "";

		try {

			// Actualiza la informaci�n de un objeto dado su id
			Libro libro = (Libro) session.load(Libro.class, id);
			libro.setTitulo(titulo);
			libro.setAutor(autor);
			libro.setAnyoNac(anyoNac);
			libro.setAnyoPub(anyoPub);
			libro.setEditorial(editorial);
			libro.setPags(pags);
			session.update(libro);

			linea += "Libro modificado correctamente --> ID: " + libro.getId() + " - T�tulo: " + libro.getTitulo()
					+ " - Autor: " + libro.getAutor() + " - A�o de nacimiento: " + libro.getAnyoNac()
					+ " - A�o de publicaci�n: " + libro.getAnyoPub() + " - Editorial: " + libro.getEditorial()
					+ " - N� de p�ginas: " + libro.getPags() + "\n";

		} catch (Exception e) {
			linea = "\nERROR en la modificaci�n de datos.";
		}

		return linea;
	}

	// M�todo: guardarBD
	// Descripci�n: hace commit de la sesi�n actual con la BD remota y cierra la sesi�n.
	// Par�metros de entrada: session (creada a trav�s de session factory en principal).
	// Par�metros de salida: string.
	public static String guardarBD(Session session) {

		String linea = "";

		try {
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			linea = "\nERROR en el guardado de la BD.";
		}

		return linea;
	}

}
