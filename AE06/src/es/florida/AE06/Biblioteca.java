package es.florida.AE06;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Biblioteca {

	public static MongoCollection<Document> mongoDBConnection() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Libros");
		return coleccion;

	}

	public static void mongoDBConnectionClose() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		mongoClient.close();
	}

	public static void mostrarTodos() {

		MongoCollection<Document> coleccion = mongoDBConnection();
		MongoCursor<Document> cursor = coleccion.find().iterator();

		System.out.println("\n <<< Listado de la Biblioteca >>>\n");
		while (cursor.hasNext()) {
			// System.out.println(cursor.next().toJson());
			JSONObject obj = new JSONObject(cursor.next().toJson());
			System.out.println(obj.getString("Id") + " - " + obj.getString("Titol"));
		}
	}

	public static void mostrarLibro(int id) {

		try {
			MongoCollection<Document> coleccion = mongoDBConnection();
			MongoCursor<Document> cursor = coleccion.find().iterator();

			Bson query = eq("Id", String.valueOf(id));
			cursor = coleccion.find(query).iterator();

			if (id > coleccion.count()) {
				System.err.println("\nNo hay ningun libro en la Base de Datos con el id: " + id);
			} else {
				while (cursor.hasNext()) {
					JSONObject obj = new JSONObject(cursor.next().toJson());
					System.out.println("\nLibro -> " + "Id: " + obj.getString("Id") + " - " + "Titulo: "
							+ obj.getString("Titol") + " - " + "Autor: " + obj.getString("Autor") + " - "
							+ "Año Nacimiento: " + obj.getString("Any_naixement") + " - " + "Editorial: "
							+ obj.getString("Editorial") + " - " + "Num. Paginas: " + obj.getString("Nombre_pagines"));
				}
			}

		} catch (Exception e) {
			System.err.println("\nNo hay ningun libro en la Base de Datos con el id: " + id);
		}

	}

	public static void crearLibro() {

	}

	public static void actualizarLibro(int id) {

	}

	public static void borrarLibro(int id) {

	}

	public static void main(String[] args) throws InterruptedException {

		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);

		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		int id;
		try {
			while (opcion != 6) {
				System.out.println("\n\n1. Mostrar todos los titulos de la Biblioteca");
				System.out.println("2. Mostrar informacion detallada de un Libro");
				System.out.println("3. Crear nuevo Libro");
				System.out.println("4. Actualizar Libro");
				System.out.println("5. Borrar Libro");
				System.out.println("6. Cerrar la Biblioteca");
				System.out.print("\n >>> Elegir una opcion: ");
				opcion = Integer.parseInt(teclado.next());

				switch (opcion) {
				case 1:
					mostrarTodos();
					break;
				case 2:
					System.out.print(">>>> Indica el numero del Libro a mostrar: ");
					id = Integer.parseInt(teclado.next());
					mostrarLibro(id);
					break;
				case 3:
					crearLibro();
					break;
				case 4:
					System.out.print(">>> Indica el numero del Libro a actualizar: ");
					id = Integer.parseInt(teclado.next());
					actualizarLibro(id);
					break;
				case 5:
					System.out.print(">>> Indica el numero del Libro a borrar: ");
					id = Integer.parseInt(teclado.next());
					borrarLibro(id);
					break;
				case 6:
					System.out.println("\nSalida de la Aplicacion...");
					teclado.close();
					mongoDBConnectionClose();
					break;
				default:
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("\n <<< Excepcion: Opcion no Admitida >>>");
			// e.printStackTrace();
		}

	}

}
