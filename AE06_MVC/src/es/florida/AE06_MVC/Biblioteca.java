/**
 * Ampliacion a Modelo Vista Controlador.
 * Desarrollar un proyecto Java que gestione objetos libro como documentos y asegure su persistencia como una colección en la base de datos MongoDB.
 */
package es.florida.AE06_MVC;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Biblioteca {

	/**
	 * Metodo para la Carga de la configuracion de conexion con la base de datos
	 * mediante el numero de puerto a la base de datos MongoDB
	 * 
	 * @return
	 */
	public static MongoCollection<Document> mongoDBConnection() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Libros");
		return coleccion;
	}

	/**
	 * Metodo para el cierre cierre de la conexion con la base de datos MongoDB
	 */
	public static void mongoDBConnectionClose() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		mongoClient.close();
	}

	/**
	 * Metodo para mostrar por pantalla todos los libros de la base de Datos,
	 * mostrando solo el Id y el Titulo del libro.
	 */
	public static String mostrarTodos() {

		String linea = "";

		MongoCollection<Document> coleccion = mongoDBConnection();
		MongoCursor<Document> cursor = coleccion.find().iterator();

		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			linea += (obj.getString("Id") + " - " + obj.getString("Titol") + "\n");
		}

		return linea;
	}

	/**
	 * Metodo que enviandole el id muestre la informacion detallada del libro
	 * 
	 * @param id
	 */
	public static String mostrarLibro(int id) {

		String linea = "";

		try {
			MongoCollection<Document> coleccion = mongoDBConnection();
			MongoCursor<Document> cursor = coleccion.find().iterator();

			Bson query = eq("Id", String.valueOf(id));
			cursor = coleccion.find(query).iterator();

			if (id > coleccion.count()) {
				linea = ("\nNo hay ningun libro en la Base de Datos con el id: " + id + "\n");
			} else {
				while (cursor.hasNext()) {
					JSONObject obj = new JSONObject(cursor.next().toJson());
					linea += ("\nLibro -> " + "Id: " + obj.getString("Id") + "\nTitulo: " + obj.getString("Titol")
							+ "\nAutor: " + obj.getString("Autor") + "\nAño Nacimiento: "
							+ obj.getString("Any_naixement") + "\nAño Publicacion: " + obj.getString("Any_publicacio")
							+ "\nEditorial: " + obj.getString("Editorial") + "\nNum. Paginas: "
							+ obj.getString("Nombre_pagines") + "\n");
				}
			}
		} catch (Exception e) {
			linea = ("\nNo hay ningun libro en la Base de Datos con el id: " + id + "\n");
		}

		return linea;
	}

	/**
	 * Metodo para la creacion de un nuevo Libro en la Base de Datos
	 */
	public static String crearLibro(String titulo, String autor, String aNacimiento, String aPublicacion,
			String editorial, String numPaginas) {

		String linea = "";
		try {
			MongoCollection<Document> coleccion = mongoDBConnection();
			Document doc = new Document();

			int idCount = (int) (coleccion.count() + 1);

			doc.append("Id", String.valueOf(idCount));
			doc.append("Titol", titulo);
			doc.append("Autor", autor);
			doc.append("Any_naixement", aNacimiento);
			doc.append("Any_publicacio", aPublicacion);
			doc.append("Editorial", editorial);
			doc.append("Nombre_pagines", numPaginas);

			coleccion.insertOne(doc);
			linea = ("\nCreado Libro en la Base de Datos Id: " + idCount);

		} catch (Exception e) {
			linea = ("\nExcepcion: No existe o no se puede actualizar el Libro...\n");
		}

		return linea;

	}

	/**
	 * Metodo que tras pasarle el id, modificar los atributos de un Libro
	 * 
	 * @param id
	 */
	public static String actualizarLibro(int id, String titulo, String autor, String aNacimiento, String aPublicacion,
			String editorial, String numPaginas) {

		String linea = "";

		try {
			MongoCollection<Document> coleccion = mongoDBConnection();
			MongoCursor<Document> cursor = coleccion.find().iterator();

			Bson query = eq("Id", String.valueOf(id));
			cursor = coleccion.find(query).iterator();

			if (id > coleccion.count()) {
				linea = ("\nNo hay ningun libro en la Base de Datos con el id: " + id + "\n");
			} else {

				JSONObject obj = new JSONObject(cursor.next().toJson());

				coleccion.updateOne(eq("Id", obj.getString("Id")),
						new Document("$set", new Document("Id", obj.getString("Id"))));
				coleccion.updateOne(eq("Titol", obj.getString("Titol")),
						new Document("$set", new Document("Titol", titulo)));
				coleccion.updateOne(eq("Autor", obj.getString("Autor")),
						new Document("$set", new Document("Autor", autor)));
				coleccion.updateOne(eq("Any_naixement", obj.getString("Any_naixement")),
						new Document("$set", new Document("Any_naixement", aNacimiento)));
				coleccion.updateOne(eq("Any_publicacio", obj.getString("Any_publicacio")),
						new Document("$set", new Document("Any_publicacio", aPublicacion)));
				coleccion.updateOne(eq("Editorial", obj.getString("Editorial")),
						new Document("$set", new Document("Editorial", editorial)));
				coleccion.updateOne(eq("Nombre_pagines", obj.getString("Nombre_pagines")),
						new Document("$set", new Document("Nombre_pagines", numPaginas)));

				linea = ("\n <<< Libro Actualizado... >>>");

			}
		} catch (Exception e) {
			linea = ("\nNo hay ningun libro en la Base de Datos con el id: " + id + "\n");
		}

		return linea;

	}

	/**
	 * Metodo a partir del id introducido, borrar el Libro de la Base de Datos
	 * 
	 * @param id
	 */
	public static String borrarLibro(int id) {

		String linea = "";

		try {
			MongoCollection<Document> coleccion = mongoDBConnection();

			if (id > coleccion.count()) {
				linea = ("\nNo hay ningun libro en la Base de Datos con el id: " + id + "\n");
			} else {
				coleccion.deleteOne(eq("Id", String.valueOf(id)));
				linea = ("\n <<< Libro borrado con Id " + id + " >>>");
			}

		} catch (Exception e) {
			linea = ("\nNo hay ningun libro en la Base de Datos con el id: " + id + "\n");
		}

		return linea;
	}

}
