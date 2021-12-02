//Ejercicio 4. Realizar un programa que dado un directorio, compruebe si existe y devuelva un mensaje de confirmación si existe 
// o una alerta en caso contrario.

package es.florida.ET01;

import java.io.File;

public class Ejercicio4 {

	public static void main(String[] args) {
		System.out.println("Ejercicio 4\n");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		if (file.exists()) {
			System.out.println("El directorio existe");
		}else {
			System.out.println("El directorio no existe");
		}

	}

}
