package es.florida.ET02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ET02_Ejercicio9 {

	public static void main(String[] args) throws IOException {
		/**
		 * Escribe un programa que reciba como parámetro de entrada la ruta de un
		 * fichero, lea su contenido y lo muestre por pantalla carácter a carácter.
		 */

		String nombreFichero = args[0];
		System.out.println("Fichero original; " + nombreFichero);
		File ficheroOriginal = new File(nombreFichero);
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
		int valor = br.read();
		while (valor != -1) {
			System.out.print((char) valor);
			valor = br.read();
		}
		br.close();
		fr.close();

	}

}
