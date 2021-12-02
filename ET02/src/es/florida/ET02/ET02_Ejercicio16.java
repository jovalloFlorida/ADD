package es.florida.ET02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ET02_Ejercicio16 {

	public static void main(String[] args) throws IOException {
		/**
		 * Modifica el programa anterior para que el nombre del fichero incluya la fecha
		 * y la hora de creación
		 */

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String nombreFichero = "input_usuario_" + timeStamp + ".txt";
		File fichero = new File(nombreFichero);
		FileWriter fw = new FileWriter(fichero);
		BufferedWriter bw = new BufferedWriter(fw);
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce texto linea a linea (termina con 'exit'): ");
		String linea = teclado.nextLine();
		while (linea.equals("exit")) {
			bw.write(linea + "\n");
			linea = teclado.nextLine();
		}
		teclado.close();
		fw.close();
		bw.close();
	}

}
