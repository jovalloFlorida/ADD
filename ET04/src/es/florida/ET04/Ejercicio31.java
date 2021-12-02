/**
 * Implementa un método que permita, dado un id de la tabla, borrar la entrada.
 */
package es.florida.ET04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class Ejercicio31 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas","root","");
			System.out.print("Introducir Id para eliminar datos: ");
			Scanner teclado =new Scanner(System.in);
			String idBorrar = teclado.nextLine();
			PreparedStatement psBorrar = con.prepareStatement("DELETE FROM peliculas WHERE id = " + idBorrar);
			int resultadoBorrar = 0;
			resultadoBorrar = psBorrar.executeUpdate();
			if (resultadoBorrar>0) {
				System.out.println("Pelicula Borrada en base de datos (fila "+ idBorrar + ")");
			}else {
				System.err.println("Error en el borrado");
			}
			psBorrar.close();
			con.close();
			teclado.close();
			
		}catch (SQLException e) {
			System.err.print("Error en la conexion");
			e.printStackTrace();
		}

	}

}
