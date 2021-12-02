package es.florida.AE04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		System.out.println("Libros (título, autor y año de publicación) de los autores nacidos antes de 1950.\n");
		try
		{
		  //Class.forName("com.mysql.jdbc.Driver");
			// Establecemos la conexión con la base de datos.
			//Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/prueba","root", "la_clave");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecaadd","root","");
			// Preparamos la consulta
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery ("SELECT titulo,autor,publicacion FROM `bibliotecaadd` WHERE nacimiento<1950");
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{
			    System.out.println (rs.getString (1) + " / " + rs.getString (2)+ " / " + rs.getString(3));
			}
			// Cerramos la conexion a la base de datos.
			conexion.close();
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("Editoriales que hayan publicado al menos un libro en el siglo XXI.\n");
		
		try
		{
		  //Class.forName("com.mysql.jdbc.Driver");
			// Establecemos la conexión con la base de datos.
			//Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/prueba","root", "la_clave");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecaadd","root","");
			// Preparamos la consulta
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery ("SELECT editorial FROM `bibliotecaadd` WHERE publicacion >= 2000 GROUP BY editorial");
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{
			    System.out.println (rs.getString (1));
			}
			// Cerramos la conexion a la base de datos.
			conexion.close();
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		}
		

	}
		

	

}
