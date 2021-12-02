package es.florida.ET02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ET02_Ejercicio12 {

	public static void main(String[] args) throws IOException {
		/**
		 * Crea un programa que dado un fichero de texto, lea y muestre su contenido
		 * línea a línea.
		 */

		String nombreFichero = args[0];
		System.out.println("Fichero original; " + nombreFichero);
		File ficheroOriginal = new File(nombreFichero);
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		while (linea != null) {
			System.out.println(linea);
			linea = br.readLine();
		}
		br.close();
		fr.close();
	}

}
