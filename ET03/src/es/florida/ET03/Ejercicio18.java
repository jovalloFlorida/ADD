/**
 * Realiza un programa que dado el fichero creado en el ejercicio anterior lo muestre por pantalla línea a línea
 */
package es.florida.ET03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Ejercicio18 {

	public static void main(String[] args) throws IOException {
		File fichero = new File("peliculas.xml");
		FileReader fr = new FileReader(fichero, StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		while (linea != null) {
			System.out.println(linea);
			linea = br.readLine();
		}
		fr.close();
		br.close();

	}

}
