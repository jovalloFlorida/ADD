package es.florida.ejercicio1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Ejercicio1 {

	public static void main(String[] args) {

		// Carga la configuracion crea un session factory
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Precios.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);

		// Abre una nueva session de la session factory
		Session session = sessionFactory.openSession();

		
		//Crear nuevos Registros
		
		session.beginTransaction();

		Scanner teclado = new Scanner(System.in);
		try {
			System.out.print("Introduce el item: ");
			String item = teclado.nextLine();
			System.out.print("Introduce el Precio: ");
			int precio = teclado.nextInt();
			System.out.print("Introduce el Precio de Oferta: ");
			int precioOferta = teclado.nextInt();
			System.out.print("Introduce el Saldo: ");
			String saldo = teclado.nextLine();
			
			

			Precios pre = new Precios(item, precio, precioOferta, saldo);
			Serializable id = session.save(pre);
			System.out.println("\nCreado Libro en la Base de Datos...");

		} catch (Exception e) {
			System.out.println("\nExcepcion: No se puede actualizar la Base de Datos Libro...");
			// e.printStackTrace();
		}
		
		
		
		
		
		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();

	}

}
