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

public class Principal {

	static String arrayTitulos[] = { "La del pirata cojo", "You can call me All" };
	static String arrayArtistas[] = { "Joaquin Sabina", "Paul Simon" };
	static int arrayAnyos[] = { 1992, 1986 };
	static String arrayFormatos[] = { "MP3", "MP4" };

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
		MongoCollection<Document> coleccion = database.getCollection("canciones");

		System.out.println("Conexion Correcta...\n");

		// Insertar un documento en la coleccion
		System.out.println("Insertar un documento...\n");
		Document doc = new Document();
		doc.append("titulo", arrayTitulos[0]);
		doc.append("artista", arrayArtistas[0]);
		doc.append("anyo", arrayAnyos[0]);
		doc.append("formato", arrayFormatos[0]);
		coleccion.insertOne(doc);

		// Insertar varios documento en la coleccion
		System.out.println("Insertar varios documentos...\n");
		ArrayList<Document> listaDocs = new ArrayList<Document>();
		for (int i = 0; i < arrayTitulos.length; i++) {
			doc = new Document();
			doc.append("titulo", arrayTitulos[i]);
			doc.append("artista", arrayArtistas[i]);
			doc.append("anyo", arrayAnyos[i]);
			doc.append("formato", arrayFormatos[i]);
			listaDocs.add(doc);
		}
		coleccion.insertMany(listaDocs);

		// Obtener tamanyo coleccion
		System.out.println("\n==========================");
		System.out.println("\nTamanyo de la colleccion: " + coleccion.count());
		System.out.println("\n==========================");

		// Obtener todos los elemntos de la coleccion
		System.out.println("\n=========================");
		System.out.println("Elementos de la coleccion");
		System.out.println("=========================\n");
		MongoCursor<Document> cursor = coleccion.find().iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}
		System.out.println("=========================\n");

		// Queries especificos
		System.out.println("\nDocumentos con anyo igual a 2016: ");
		Bson query = eq("anyo", 2016);
		cursor = coleccion.find(query).iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		System.out.println("\nDocumentos con artista igual a Joaquin Sabina: ");
		query = eq("artista", "Joaquin Sabina");
		cursor = coleccion.find(query).iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		System.out.println("\nDocumentos con a�o posterior a 1980: ");
		query = gte("anyo", 1980);
		cursor = coleccion.find(query).iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		System.out.println("\nTitulos con a�o posterior a 1980: ");
		query = gte("anyo", 1980);
		cursor = coleccion.find(query).iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			System.out.println(obj.getString("titulo"));
		}

		// Actualizar
		System.out.println("\n=========================");
		System.out.println("Elementos de la coleccion");
		System.out.println("=========================\n");
		cursor = coleccion.find(query).iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		System.out.println("\nActualizar solo 1 documento cambiando WAW a OGG");
		coleccion.updateOne(eq("formato", "WAV"), new Document("$set", new Document("formato", "OGG")));

		System.out.println("\n=========================");
		System.out.println("Elementos de la coleccion");
		System.out.println("=========================\n");
		cursor = coleccion.find(query).iterator();
		while (cursor.hasNext()) {
			System.out.println(cursor.next().toJson());
		}

		// Borrar
		System.out.println("Tama�o coleccion: " + coleccion.count());
		System.out.println("Tama�o coleccion: " + coleccion.countDocuments());
		System.out.println("Tama�o coleccion: " + coleccion.estimatedDocumentCount());

		System.out.println("Borrar elemento con formato OGG");
		coleccion.deleteOne(eq("formato", "OGG"));
		System.out.println("Tama�o coleccion: " + coleccion.count());

		System.out.println("Borrar todo elemento con formato RAW");
		coleccion.deleteMany(eq("formato", "RAW"));
		System.out.println("Tama�o coleccion: " + coleccion.count());

		System.out.println("Borrar toda la coleccion");
		coleccion.drop();
		System.out.println("Tama�o coleccion: " + coleccion.count());

		mongoClient.close();

	}

}
