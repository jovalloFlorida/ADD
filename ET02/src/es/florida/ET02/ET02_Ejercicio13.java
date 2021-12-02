package es.florida.ET02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ET02_Ejercicio13 {

	public static void main(String[] args) throws IOException, InterruptedException {
		/**
		 * Modifica el programa anterior para que acepte como parámetros de entrada un
		 * número que indique la velocidad a la que se muestran las líneas.
		 */

		String nombreFichero = args[0];
		int velocidad = Integer.parseInt(args[1]);
		System.out.println("Fichero original; " + nombreFichero);
		File ficheroOriginal = new File(nombreFichero);
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		while (linea != null) {
			System.out.println(linea);
			linea = br.readLine();
			Thread.sleep(velocidad);
		}
		br.close();
		fr.close();
	}

}
