//Ejercicio 2. Ampliar el programa anterior para que muestre todas las características de interés del directorio, 
// tomando como referencia la información que proporciona la clase File.

package es.florida.ET01;

import java.io.File;
import java.util.Date;

public class Ejercicio2 {

	public static void main(String[] args) {
		System.out.println("Ejercicio 2\n");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		System.out.println("Ejecutable? " + file.canExecute());
		System.out.println("Lectura? " + file.canRead());
		System.out.println("Escritura? " + file.canWrite());
		System.out.println("Ruta absoluta? " + file.getAbsolutePath());
		System.out.println("Espacio libre? " + file.getFreeSpace()/1024/1024/1024 + " GB");
		System.out.println("Espacio total? " + file.getTotalSpace()/1024/1024/1024 + " GB");
		System.out.println("Padre? " + file.getParent());
		System.out.println("Nombre? " + file.getName());
		System.out.println("Absoluto? " + file.isAbsolute());
		System.out.println("directorio? " + file.isDirectory());
		System.out.println("Fichero? " + file.isFile());
		System.out.println("Ultima Modificacion? " + file.lastModified());
		System.out.println("Ultima Modificacion? " + new Date(file.lastModified()));
		System.out.println("Contenido: ");
		String[] lista=file.list();
		for (String elemento : lista){
			System.out.println(elemento);
		}
		


	}

}
