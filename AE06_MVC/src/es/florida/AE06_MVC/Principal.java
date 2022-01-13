package es.florida.AE06_MVC;

import java.util.logging.Logger;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;

public class Principal {

	public static void main(String[] args) {

		try {
			
			Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
			mongoLogger.setLevel(Level.SEVERE);
			
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase database = mongoClient.getDatabase("Biblioteca");
			MongoCollection<Document> coleccion = database.getCollection("Libros");

			/**
			 * Ejecución del modelo vista controlador
			 */
			Vista vista = new Vista();
			Biblioteca biblioteca = new Biblioteca();
			Controlador controlador = new Controlador(vista, biblioteca, coleccion);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
