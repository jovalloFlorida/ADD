package es.florida.ET02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ET02_Ejercicio10 {

	public static void main(String[] args) throws IOException, InterruptedException {
		/**
		 * Introduce una modificación en el programa anterior para que admita otro
		 * parámetro de entrada adicional que permita especificar la velocidad a la que
		 * se muestren los caracteres.
		 */

		String nombreFichero = args[0];
		int velocidad = Integer.parseInt(args[1]);
		System.out.println("Fichero original; " + nombreFichero);
		File ficheroOriginal = new File(nombreFichero);
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
		int valor = br.read();
		while (valor != -1) {
			System.out.print((char) valor);
			valor = br.read();
			Thread.sleep(velocidad);
		}
		br.close();
		fr.close();

	}
}
