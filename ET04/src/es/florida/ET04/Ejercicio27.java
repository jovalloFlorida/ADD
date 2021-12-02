/**
 * Amplía el programa anterior para que implemente el código necesario para interrogar a la base de datos 
 * con una sentencia SQL. Implementa una sentencia que permita recuperar todo el contenido de una tabla 
 * de la base de datos.
 */
package es.florida.ET04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class Ejercicio27 {

	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas","root","");
			System.out.println("Conexion correcta");
			Statement stmt = con.createStatement();
			ResultSet rs =stmt.executeQuery("SELECT * FROM peliculas");
			rs.close();
			con.close();
		}catch (SQLException e) {
			System.err.print("Error en la conexion");
			e.printStackTrace();
		}

	}

}