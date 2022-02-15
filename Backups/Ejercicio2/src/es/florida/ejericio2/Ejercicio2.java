package es.florida.ejericio2;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Ejercicio2 {

	public static void main(String[] args) {

		try {

			// Para que no aparezcan las conexion a MontgoDB por consola
			Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
			mongoLogger.setLevel(Level.SEVERE);

			// Metodo para la Carga de la configuracion de conexion con la base de datos
			// mediante el numero de puerto a la base de datos MongoDB
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase database = mongoClient.getDatabase("SistemaSolar");
			MongoCollection<Document> coleccion = database.getCollection("Planetas");
			MongoCursor<Document> cursor = coleccion.find().iterator();

			// 1. Mostrar un lista de la coleccion donde solo aparezca el nombre del planeta
			// y
			// numero de lunas que tienes

			System.out.println("\n <<< Listado de Nombre de planetas y lunas >>>\n");
			while (cursor.hasNext()) {
				JSONObject obj = new JSONObject(cursor.next().toJson());
				System.out
						.println("Nombre: " + obj.getString("nombrePlaneta") + " - " + "Lunas: " + obj.getInt("lunas"));

			}

			// 2. Mostrar informacion completa a partir de su nombre

			Scanner teclado = new Scanner(System.in);
			System.out.print("\n>>> Indica el nombre del planeta a mostrar: ");
			String planeta = teclado.nextLine();
			Bson query = eq("nombrePlaneta", String.valueOf(planeta));
			cursor = coleccion.find(query).iterator();
			while (cursor.hasNext()) {
				JSONObject obj = new JSONObject(cursor.next().toJson());
				System.out.println("\nInformacion Planeta -> " + "Nombre Planeta: " + obj.getString("nombrePlaneta")
						+ " - " + "Distancia Sol: " + obj.getInt("distanciaSol") + " - " + "Gravedad: "
						+ obj.getDouble("gravedad") + " - " + "Periodo Orbital: " + obj.getInt("periodoOrbital") + " - "
						+ "Lunas: " + obj.getInt("lunas"));
			}

			// 3. Mostrar solo los campos nombreplaneta y distanciaSol de los planetas que
			// se encuentran mas alla de marte

			MongoClient mongoClient2 = new MongoClient("localhost", 27017);
			MongoDatabase database2 = mongoClient2.getDatabase("SistemaSolar");
			MongoCollection<Document> coleccion2 = database2.getCollection("Planetas");
			MongoCursor<Document> cursor2 = coleccion2.find().iterator();
			System.out
					.println("\n <<< Listado de Nombre de planetas y distancia a sol del Sistema Solar Exterior >>>\n");
			while (cursor2.hasNext()) {
				JSONObject obj2 = new JSONObject(cursor2.next().toJson());
				if (obj2.getInt("distanciaSol") > 227) {
					System.out.println("Nombre: " + obj2.getString("nombrePlaneta") + " - " + "Distancia Sol: "
							+ obj2.getInt("distanciaSol") + " dias");
				}
			}

			// 4. Se ha descubierto una nueva luna en Saturno. Actualiza la base de datos

			MongoClient mongoClient3 = new MongoClient("localhost", 27017);
			MongoDatabase database3 = mongoClient3.getDatabase("SistemaSolar");
			MongoCollection<Document> coleccion3 = database3.getCollection("Planetas");
			MongoCursor<Document> cursor3 = coleccion3.find().iterator();

			Bson query2 = eq("nombrePlaneta", String.valueOf("Saturno"));
			cursor3 = coleccion.find(query2).iterator();
			JSONObject obj = new JSONObject(cursor3.next().toJson());

			coleccion.updateOne(eq("nombrePlaneta", obj.getString("nombrePlaneta")),
					new Document("$set", new Document("nombrePlaneta", obj.getString("nombrePlaneta"))));

			coleccion.updateOne(eq("distanciaSol", obj.getInt("distanciaSol")),
					new Document("$set", new Document("distanciaSol", obj.getInt("distanciaSol"))));

			coleccion.updateOne(eq("gravedad", obj.getDouble("gravedad")),
					new Document("$set", new Document("gravedad", obj.getDouble("gravedad"))));

			coleccion.updateOne(eq("periodoOrbital", obj.getInt("periodoOrbital")),
					new Document("$set", new Document("periodoOrbital", obj.getInt("periodoOrbital"))));

			coleccion.updateOne(eq("lunas", obj.getInt("lunas")),
					new Document("$set", new Document("lunas", (obj.getInt("lunas") + 1))));

			System.out.println("\nActualizadas las lunas de Saturno...");

			// 5. Implementa el codigo para mostrar una lista donde aparezcan los nombres de
			// los planetas

			// 6. Eliminar la coleccion

			MongoClient mongoClient6 = new MongoClient("localhost", 27017);
			MongoDatabase database6 = mongoClient6.getDatabase("SistemaSolar");
			MongoCollection<Document> coleccion6 = database6.getCollection("Planetas");

			Scanner teclado2 = new Scanner(System.in);
			System.out.print("\nRealmente quiere eliminar la coleccion Planetas (S/N): ");
			String eleccion = teclado2.nextLine();

			if (eleccion == "S") {
				coleccion6.drop();
				System.out.println("\nColeccion Planetas eliminada...");
			} else {
				System.out.println("\nColeccion Planetas no ha sido eliminada...");
			}

			mongoClient.close();
			teclado.close();
			teclado2.close();

		} catch (

		Exception e) {

		}

	}

}
