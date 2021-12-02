package es.florida.Examen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Examen {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub

		//Ejercicio1
		System.out.println("Ejercicio 1\n");
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
		System.out.println("\nEjercicio 2");
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection(urlXML,userXML,passwdXML);
			System.out.println("Conexion correcta");
			con.close();
		}catch (SQLException e) {
			System.err.print("Error en la conexion");
			e.printStackTrace();
		}

		
		//Ejercicio3
		System.out.println("\nEjercicio 3 / 4");
		System.out.print("Introduce el precio maximo: ");
		Scanner teclado = new Scanner(System.in);
		String respuesta = teclado.nextLine();
		teclado.close();
		
		//Ejercicio 4 y 5 y 6
		System.out.println("\nEjercicio 4 y 5 y 6");
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String nombreFichero = "consulta"+ timeStamp +".txt";
		File fichero = new File(nombreFichero);
		FileWriter fw = new FileWriter(fichero);
		BufferedWriter bw = new BufferedWriter(fw);
		//bw.write(linea + "\n")
		
		
		try {
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","");
			
			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery ("SELECT * FROM `precios` WHERE precio <= " + respuesta);
						
						
			while (rs.next())
			{
				String linea = ("Nombre: " + rs.getString (2) + " / " + "Precio: " + rs.getString (3));
				System.out.println (linea);
				bw.write(linea + "\n");
			}
			// Cerramos la conexion a la base de datos.
			conexion.close();
			bw.close();
		   
		} catch (Exception e)
		{
		   e.printStackTrace();
		}
		
		
	}

}
