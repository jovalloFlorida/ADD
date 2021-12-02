//Ejercicio 6 Modifica el programa anterior para que tenga en cuenta que si no se le pasa ninguna extensión como parámetro 
// muestre todo el contenido del directorio.

package es.florida.ET01;

import java.io.File;

public class Ejercicio6 {

	public static void main(String[] args) {
		System.out.println("Ejercicio 6\n");
		String directorio = args[0];
		System.out.println("Directorio: " + directorio);
		File file = new File(directorio);
		if (args.length > 1) {
			FiltroExtension filtro = new FiltroExtension(args[1]);
			String[] lista = file.list(filtro);
			for (String elemento : lista) {
				System.out.println(elemento);
			}
		} else {
			String[] lista = file.list();
			for (String elemento : lista) {
				System.out.println(elemento);
			}
		}
	}
}
