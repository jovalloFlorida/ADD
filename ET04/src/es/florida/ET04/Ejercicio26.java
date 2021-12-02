/**
 * Realiza un programa que importe la librería necesaria para poder realizar una conexión a una base de
 *  datos MySQL, realice la conexión a la base de datos anterior y muestre un mensaje si se ha hecho 
 *  o no con éxito.
 */
package es.florida.ET04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Ejercicio26 {

	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas","root","");
			System.out.println("Conexion correcta");
			con.close();
		}catch (SQLException e) {
			System.err.print("Error en la conexion");
			e.printStackTrace();
		}

	}

}
