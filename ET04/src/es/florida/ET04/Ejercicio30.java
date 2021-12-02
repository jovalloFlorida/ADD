/**
 * Implementa un método que permita, dado un id de la tabla, actualizar alguno de sus campos (el nuevo valor del campo se introducirá por teclado).
 */
package es.florida.ET04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class Ejercicio30 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas","root","");
			System.out.print("Introducir Id para modificar datos: ");
			Scanner teclado =new Scanner(System.in);
			String idModificar = teclado.nextLine();
			System.out.print("Titulo: "); String titulo = teclado.nextLine();
			System.out.print("Director: "); String director = teclado.nextLine();
			System.out.print("Puntuacion: "); String puntuacion = teclado.nextLine();
			System.out.print("Genero: "); String genero = teclado.nextLine();
			PreparedStatement psActualizar = con.prepareStatement("UPDATE peliculas SET titulo = '" + titulo + "', director = '" + director 
					+ "' , puntuacion = '" + puntuacion + "', genero = '" + genero + "' WHERE id = " + idModificar);
			int resultadoActualizar = 0;
			resultadoActualizar = psActualizar.executeUpdate();
			if (resultadoActualizar>0) {
				Pelicula nuevaPelicula = new Pelicula(titulo,director,puntuacion,genero);
				System.out.println("Pelicula Modificada en base de datos (fila "+ resultadoActualizar + "): " + nuevaPelicula.toString());
			}else {
				System.err.println("Error en la insercion");
			}
			psActualizar.close();
			con.close();
			teclado.close();
		}catch (SQLException e) {
			System.err.print("Error en la conexion");
			e.printStackTrace();
		}
		
	}

}
