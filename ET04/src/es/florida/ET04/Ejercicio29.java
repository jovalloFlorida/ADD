/**
 * Implementa un método que permita leer por teclado los atributos para una nueva entrada en la tabla (puedes utilizar lo que ya has desarrollado 
 * en el bloque anterior), cree la consulta adecuada de inserción e introduzca los nuevos datos en la base de datos. 
 * Comprueba después que la inserción se ha realizado correctamente.
 */
package es.florida.ET04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;


public class Ejercicio29 {

	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas","root","");
			PreparedStatement psInsertar = con.prepareStatement("INSERT INTO peliculas (titulo,director,puntuacion,genero) VALUES (?,?,?,?)");
			System.out.print("Desea añadir nueva pelicula (s/n): ");
			Scanner teclado =new Scanner(System.in);
			String respuesta = teclado.nextLine();
			while (respuesta.equals("s")) {
				System.out.print("Titulo: "); String titulo = teclado.nextLine();
				System.out.print("Director: "); String director = teclado.nextLine();
				System.out.print("Puntuacion: "); String puntuacion = teclado.nextLine();
				System.out.print("Genero: "); String genero = teclado.nextLine();
				psInsertar.setString(1,titulo);
				psInsertar.setString(2,director);
				psInsertar.setString(3,puntuacion);
				psInsertar.setString(4,genero);
				int resultadoInsertar= psInsertar.executeUpdate();
				Pelicula nuevaPelicula = new Pelicula(titulo,director,puntuacion,genero);
				if (resultadoInsertar > 0) {
					System.out.println("Pelicula guardada en base de datos (fila "+ resultadoInsertar + "): " + nuevaPelicula.toString());
				} else {
					System.err.println("Error en la insercion");
				}
				System.out.print("Desea añadir nueva pelicula (s/n): ");
				respuesta = teclado.nextLine();
			}
			con.close();
			psInsertar.close();
			teclado.close();
		}catch (SQLException e) {
			System.err.print("Error en la conexion");
			e.printStackTrace();
		}

	}

}