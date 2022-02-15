package es.florida.ET06;

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

public class PruebaConexion {

	public static void main(String[] args) {

		try {
			
			//Para que no aparezcan las conexion a MontgoDB por consola
			//Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
			//mongoLogger.setLevel(Level.SEVERE);
			
			// Metodo para la Carga de la configuracion de conexion con la base de datos
			// mediante el numero de puerto a la base de datos MongoDB
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
			MongoCollection<Document> coleccion = database.getCollection("canciones");
					
			
			System.out.println("\nConexion realizada correctamente...\n");
			

			// Consultar tamaño de la coleccion
			System.out.println("Tamaño coleccion: " + coleccion.count());
			System.out.println("Tamaño coleccion: " + coleccion.countDocuments());
			System.out.println("Tamaño coleccion: " + coleccion.estimatedDocumentCount());

			mongoClient.close();
		
		}catch (Exception e) {
			System.err.println("\nConexion fallida...\n");
		}
		



	}

}
