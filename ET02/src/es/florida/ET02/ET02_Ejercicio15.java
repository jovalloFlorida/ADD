package es.florida.ET02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ET02_Ejercicio15 {

	public static void main(String[] args) throws IOException {
		/**
		 * Realiza un programa que permita recibir por teclado una serie de strings por
		 * parte del usuario y los vaya escribiendo en un fichero de texto. Como
		 * condición de finalización, el usuario deberá escribir un string que sea
		 * “exit”.
		 */

		String nombreFichero = "input_usuario.txt";
		File fichero = new File(nombreFichero);
		FileWriter fw = new FileWriter(fichero);
		BufferedWriter bw = new BufferedWriter(fw);
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce texto linea a linea (termina con 'exit'): ");
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
