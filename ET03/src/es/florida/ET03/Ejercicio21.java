/**
 * Introduce en el programa anterior un método que implemente la clase objeto que has elegido para el XML. Puede ser un objeto Java común (POJO, Plain Old Java Object) con constructor, setters y getters.
 */
package es.florida.ET03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio21 {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Clase Pelicula.java");
		File ficheroClase = new File("./src/es/florida/ET03/Pelicula.java");
		FileReader fr = new FileReader(ficheroClase);
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
