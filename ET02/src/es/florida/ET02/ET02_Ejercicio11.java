package es.florida.ET02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ET02_Ejercicio11 {

	public static void main(String[] args) throws IOException, InterruptedException {
		/**
		 * Realiza otro programa que muestre un número determinado de caracteres por
		 * pantalla (por ejemplo 100), espere a que el usuario presione alguna tecla,
		 * muestre otro bloque de caracteres, vuelva a esperar, y así sucesivamente
		 * hasta mostrar todo el contenido.
		 */

		String nombreFichero = args[0];
		System.out.println("Fichero original; " + nombreFichero);
		File ficheroOriginal = new File(nombreFichero);
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
		int contador = 0;
		int valor = br.read();
		while (valor != -1) {
			System.out.print((char) valor);
			contador++;
			valor = br.read();
			if (contador == 100) {
				System.in.read();
				contador = 0;
				Thread.sleep(100);
			}

		}
		br.close();
		fr.close();
	}

}
