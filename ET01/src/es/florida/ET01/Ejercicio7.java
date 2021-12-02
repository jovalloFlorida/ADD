//Ejercicio 7 Modifica el programa anterior para que admita como parámetros de entrada un número cualquiera de extensiones, 
// devolviendo después por pantalla todos los ficheros del directorio que tengan alguna de las extensiones indicadas

package es.florida.ET01;

import java.io.File;

public class Ejercicio7 {

	public static void main(String[] args) {
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		int numExtensiones = args.length - 1;
		for (int i = 1; i <= numExtensiones; i++) {
			FiltroExtension filtro = new FiltroExtension(args[i]);
			String[] lista = file.list(filtro);
			for (String elemento : lista) {
				System.out.println(elemento);
			}
		}

	}

}
