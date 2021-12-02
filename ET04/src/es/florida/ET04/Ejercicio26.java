/**
 * Realiza un programa que importe la librer�a necesaria para poder realizar una conexi�n a una base de
 *  datos MySQL, realice la conexi�n a la base de datos anterior y muestre un mensaje si se ha hecho 
 *  o no con �xito.
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
