package es.florida.ET06;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;

public class Pruebas {

	static String arrayTitulos[] = { "La del pirata cojo", "You can call me All" };
	static String arrayArtistas[] = { "Joaquin Sabina", "Paul Simon" };
	static int arrayAnyos[] = { 1992, 1986 };
	static String arrayFormatos[] = { "MP3", "MP4" };

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
		MongoCollection<Document> coleccion = database.getCollection("canciones");

		// Consultar tamaño de la coleccion
		System.out.println("Tamaño coleccion: " + coleccion.count());
		System.out.println("Tamaño coleccion: " + coleccion.countDocuments());
		System.out.println("Tamaño coleccion: " + coleccion.estimatedDocumentCount());

		mongoClient.close();

	}

}
