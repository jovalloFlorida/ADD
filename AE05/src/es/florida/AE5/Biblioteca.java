package es.florida.AE5;

import java.util.Scanner;

public class Biblioteca {

	public static void mostrarTodos() {

	}

	public static void mostrarLibro(int id) {

	}

	public static void crearLibro() {

	}
	
	public static void actualizarLibro(int id) {

	}
	
	public static void borrarLibro(int id) {

	}
	
	
	
	public static void main(String[] args) {

		// lista = recuperarTodos();
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		int id;

		while (opcion != 6) {
			System.out.println("\n\n1. Mostrar todos los titulos de la biblioteca");
			System.out.println("2. Mostrar informacion detallada de un libro");
			System.out.println("3. Crear nuevo libro");
			System.out.println("4. Actualizar libro");
			System.out.println("5. Borrar libro");
			System.out.println("6. Cerrar la biblioteca");
			System.out.print("\n >>> Elegir una opcion: ");
			opcion = Integer.parseInt(teclado.next());

			switch (opcion) {
			case 1:
				mostrarTodos();
				break;
			case 2:
				System.out.print(" >> Indica el numero del libro a mostrar: ");
				id = Integer.parseInt(teclado.next());
				mostrarLibro(id);
				break;
			case 3:
				crearLibro();
				break;
			case 4:
				System.out.print(" >> Indica el numero del libro a actualizar: ");
				id = Integer.parseInt(teclado.next());
				actualizarLibro(id);
				break;
			case 5:
				System.out.print(" >> Indica el numero del libro a borrar: ");
				id = Integer.parseInt(teclado.next());
				borrarLibro(id);
				break;
			case 6:
				System.out.println("Salida de la Aplicacion...");
				teclado.close();
				break;
			default:
				break;
			}
		}
	}

}
