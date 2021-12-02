/**
 * Crea un proyecto en Java que permita realizar las operaciones de migración de datos CSV a MySQL. 
 * Además, deberá mostrar por defecto los resultados de las siguientes consultas:
 * Libros (título, autor y año de publicación) de los autores nacidos antes de 1950.
 * Editoriales que hayan publicado al menos un libro en el siglo XXI.
 */
package es.florida.AE04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class Biblioteca {
	/**
	 * Clase Principal para ejecutar el menu Principal
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		menuPrincipal();
	}

	/**
	 * Listado de las opciones a elegir en el proyecto
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void menuPrincipal() throws ClassNotFoundException, SQLException{

		try {
			System.out.println("\n\n");
			System.out.println("1. Improtar fichero .csv a Base de datos");
			System.out.println("2. Consultas (Libros/Editoriales)");
			System.out.println("3. Ejecutar cualquier consulta SQL");
			System.out.println("4. Cerrar la biblioteca\n");
			System.out.print("Eligen una Opcion del 1 al 4: ");
			Scanner teclado = new Scanner(System.in);
			String respuesta = teclado.nextLine();

			switch (respuesta) {
			case "1":
				traspasoDatos();
				break;
			case "2":
				consultasSQL();
				;
				break;
			case "3":
				cualquierConsultaSQL();
				break;
			case "4":
				System.out.println("\nSalida de la Aplicacion");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}

			teclado.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Lectura desde un fichero .csv y trapaso de informacion a una Base de Datos MySQL creada en XAMPP
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void traspasoDatos() throws ClassNotFoundException, SQLException{
	
		Class.forName("com.mysql.cj.jdbc.Driver");		
		String file = "AE04_T1_4_JDBC_Datos.csv";
		BufferedReader br = null;
		String line = "";
		//Se define separador ";"
		String separador = ";";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecaadd","root","");
			PreparedStatement psInsertar = con.prepareStatement("INSERT INTO bibliotecaadd (titulo,autor,nacimiento,publicacion,editorial,numpaginas) VALUES (?,?,?,?,?,?)");
			int indice = 1;
			
		    br = new BufferedReader(new FileReader(file));
		    while ((line = br.readLine()) != null) {
		    	if (indice != 1) {
		    		String[] datos = line.split(separador);
			        //Comprobamos los campos vacios y le agragamos N.C
		    		for (int i=0; i<6;i++){
		    			if (datos[i]=="") {
		    				datos[i]="N.C";
		    			}
		    		}
		    		//Imprime datos.
			        String titulo = datos[0];
					String autor = datos[1];
					String nacimiento = datos[2];
					String publicacion = datos[3];
					String editorial = datos[4];
					String numpaginas = datos[5];
					
					psInsertar.setString(1,titulo);
					psInsertar.setString(2,autor);
					psInsertar.setString(3,nacimiento);
					psInsertar.setString(4,publicacion);
					psInsertar.setString(5,editorial);
					psInsertar.setString(6,numpaginas);
					int resultadoInsertar= psInsertar.executeUpdate();
					if (resultadoInsertar > 0) {
						System.out.println("Libro guardado en base de datos LibreriaADD");
					} else {
						System.err.println("Error en la insercion");
					}
			        System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5]);
		    	}
		        indice = indice + 1;
		    }
		    br.close();
		    con.close();
			psInsertar.close();
					    
		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		System.out.print("\nQuieres hacer otra operacion (s/n): ");
		Scanner nuevaOperacion = new Scanner(System.in);
		String respuesta = nuevaOperacion.nextLine();
		if (respuesta.equals("s"))
			menuPrincipal();
		nuevaOperacion.close();

	}

	/**
	 * Realizacion de las consultas en SQL que ataca a la base de datos anteriormente creada. Consultas a realizar:
	 * 1. Libros (título, autor y año de publicación) de los autores nacidos antes de 1950.
	 * 2. Editoriales que hayan publicado al menos un libro en el siglo XXI.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void consultasSQL() throws ClassNotFoundException, SQLException{
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
		
		System.out.print("\nQuieres hacer otra operacion (s/n): ");
		Scanner nuevaOperacion = new Scanner(System.in);
		String respuesta = nuevaOperacion.nextLine();
		if (respuesta.equals("s"))
			menuPrincipal();
		nuevaOperacion.close();
		
	} 

	/**
	 * Realizacion de cualquier consulta introducida por el usuario atacando a la base de datos anteriormente creada.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void cualquierConsultaSQL() throws ClassNotFoundException, SQLException{
		
		try {
					  
			System.out.print("Introduce la consulta en SQL: ");
			Scanner consultaSQL = new Scanner(System.in);
			String respuesta = consultaSQL.nextLine();
			//consultaSQL.close();			
			
			// Establecemos la conexión con la base de datos.
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecaadd","root","");
			// Preparamos la consulta
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery (respuesta);
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{
			    System.out.println (rs.getString (1) + " / " + rs.getString (2) + " / " + rs.getString(3) + " / " + rs.getString(4) + " / " + rs.getString(5) + " / " + rs.getString(6));
			}
			// Cerramos la conexion a la base de datos.
			conexion.close();
			
		} catch (Exception e)
		{
		   e.printStackTrace();
		}
		
			
		System.out.print("\nQuieres hacer otra operacion (s/n): ");
		Scanner nuevaOperacion = new Scanner(System.in);
		String respuesta = nuevaOperacion.nextLine();
		if (respuesta.equals("s"))
			menuPrincipal();
		nuevaOperacion.close();
		
		
	} 
	
}


