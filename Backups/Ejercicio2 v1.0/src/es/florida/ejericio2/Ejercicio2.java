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
			
			//Para que no aparezcan las conexion a MontgoDB por consola
			Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
			mongoLogger.setLevel(Level.SEVERE);
			
			// Metodo para la Carga de la configuracion de conexion con la base de datos
			// mediante el numero de puerto a la base de datos MongoDB
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase database = mongoClient.getDatabase("SistemaSolar");
			MongoCollection<Document> coleccion = database.getCollection("Planetas");
					
			System.out.println("Tamaño coleccion: " + coleccion.count());
			
			//Mostrar un lista de la coleccion donde solo aparezca el nombre del planeta y numero de lunas que tienes
			
			//MongoCollection<Document> coleccion = mongoDBConnection();
			MongoCursor<Document> cursor = coleccion.find().iterator();

			System.out.println("\n <<< Listado de Nombre de planetas y lunas >>>\n");
			while (cursor.hasNext()) {
				JSONObject obj = new JSONObject(cursor.next().toJson());
				System.out.println("Nombre: " + obj.getString("nombrePlaneta")+ " - " + "Lunas: "+ obj.getInt("lunas"));
				//System.out.println(obj.getString("nombrePlaneta") + " - " + obj.getString("lunas"));
			}
			
			
			
			
			
		
		}catch (Exception e) {
			
		}

		
		
		
	}

}
