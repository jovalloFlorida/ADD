package es.florida.Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Examen {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub

		//Ejercicio1
		System.out.println("Ejercicio1\n");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(new File("config.xml"));
		Element raiz = document.getDocumentElement();
		System.out.println("Contenido XML " + raiz.getNodeName() + ":");
		NodeList nodeList = document.getElementsByTagName("config1");
		System.out.println("Numero total de nodos (configurations): " + nodeList.getLength());
		
		
		Node nodo = nodeList.item(0);
		Element elemento = (Element) nodo;
		String urlXML= elemento.getElementsByTagName("url").item(0).getTextContent();
		String userXML= elemento.getElementsByTagName("user").item(0).getTextContent();
		String passwdXML= elemento.getElementsByTagName("password").item(0).getTextContent();
		
		System.out.println("url: " + urlXML);
		System.out.println("user: " + userXML);
		System.out.println("password: " + passwdXML);
		
		//Ejericio2
		
		System.out.println("\nEjercicio2");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","");
			System.out.println("Conexion correcta");
			con.close();
		}catch (SQLException e) {
			System.err.print("Error en la conexion");
			e.printStackTrace();
		}

		
		//Ejercicio3
		System.out.println("\nEjercicio3");
		System.out.print("Introduce el precio maximo: ");
		Scanner teclado = new Scanner(System.in);
		String respuesta = teclado.nextLine();
		teclado.close();
		
		//Ejercicio4 y 5
		System.out.println("\nEjercicio4");
		try {
			// Establecemos la conexión con la base de datos.
			//Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/prueba","root", "la_clave");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","");
			// Preparamos la consulta
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery ("SELECT * FROM `precios` WHERE precio <= " + respuesta);
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
			while (rs.next())
			{
			    System.out.println ("Nombre del producto: " + rs.getString (1) + " / " + "Precio del Producto: " + rs.getString (2));
			}
			// Cerramos la conexion a la base de datos.
			conexion.close();
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		}
		
	}

}
