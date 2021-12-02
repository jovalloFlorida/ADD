package es.florida.AE02;

import java.io.IOException;

/**
 * Creacion de una interface grafica siguiendo el patron MVC
 * 
 * @author Jose Valverde
 *
 */

public class Principal {

	/**
	 * Clase Principal con la entrada al programa Creacion de los objetos vista,
	 * modelo y controlador
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vista);

	}

}
