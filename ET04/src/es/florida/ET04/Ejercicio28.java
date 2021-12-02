/**
 * Para comprobar que efectivamente se han recuperado todos los datos, implementar el código para recorrer 
 * el resultado de la consulta y mostrar por pantalla las entradas de la tabla. 
 * Puedes utilizar concatenación de strings para que el formato de salida sea más comprensible.
 */
package es.florida.ET04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class Ejercicio28 {

	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas","root","");
			System.out.println("Conexion correcta");
			Statement stmt = con.createStatement();
			ResultSet rs =stmt.executeQuery("SELECT * FROM peliculas");
			System.out.format("%3s%30s%20s%15s%20s%2s","id","Titulo","Director","Puntuacion","Genero","\n");
			System.out.format("%3s%30s%20s%15s%20s%2s","--","------","--------","----------","------","\n");
			while (rs.next()) {
				System.out.format("%3s%30s%20s%15s%20s%2s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),"\n");
			}
			rs.close();
			con.close();
		}catch (SQLException e) {
			System.err.print("Error en la conexion");
			e.printStackTrace();
		}

	}

}