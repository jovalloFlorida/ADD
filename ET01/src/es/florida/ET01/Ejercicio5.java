//Ejercicio 5. Realiza un programa que reciba como parámetros de entrada un directorio y una extensión de fichero (por ejemplo .txt) 
// y devuelva por pantalla todos los ficheros del directorio que cumplan el criterio. 

package es.florida.ET01;

import java.io.File;

public class Ejercicio5 {

	public static void main(String[] args) {
		System.out.println("Ejercicio 5\n");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		//System.out.println("Ruta absoluta? " + file.getAbsolutePath());
		FiltroExtension filtro = new FiltroExtension(args[1]);
		String[] lista = file.list(filtro);
		for (String elemento : lista) {
			System.out.println(elemento);
		}
	}
}
