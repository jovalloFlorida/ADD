package es.florida.AE05;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Biblioteca {

	public static Session sessionConnection() {
		// Carga la configuraciony crea un session factory
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Libro.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);

		// Abre una nueva sessionde la session factory
		Session session = sessionFactory.openSession();
		return session;
	}

	public static void mostrarTodos() {
		Session session = sessionConnection();
		session.beginTransaction();

		List listaLibros = new ArrayList();
		listaLibros = session.createQuery("FROM Libro").list();
		for (Object obj : listaLibros) {
			Libro lib = (Libro) obj;
			System.out.println(lib.toString());
		}

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
		System.out.println("Commit de la transaction y cierre de sesion");

	}

	public static void mostrarLibro(int id) {
		Session session = sessionConnection();
		session.beginTransaction();

		Libro libro1 = (Libro) session.get(Libro.class, id);
		if (libro1 == null) {
			System.out.println("No hay ningun libro en la Base de Datos con el id: " + id);
		} else {
			System.out.println("El Titulo del Libro con Id " + id + ": " + libro1.getTitulo());
		}

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
		System.out.println("Commit de la transaction y cierre de sesion");
	}

	public static void crearLibro() {
		Session session = sessionConnection();
		session.beginTransaction();

		Scanner teclado = new Scanner(System.in);
		try {
			System.out.print("Introduce el Titulo: ");
			String titulo = teclado.nextLine();
			System.out.print("Introduce el Autor: ");
			String autor = teclado.nextLine();
			System.out.print("Introduce el Año Nacimiento: ");
			String nacimiento = teclado.nextLine();
			System.out.print("Introduce el Año Publicacion: ");
			String publicacion = teclado.nextLine();
			System.out.print("Introduce el nombre de la Editorial: ");
			String editorial = teclado.nextLine();
			System.out.print("Introduce el numero de paginas: ");
			String numpaginas = teclado.nextLine();

			Libro lib = new Libro(titulo, autor, nacimiento, publicacion, editorial, numpaginas);
			Serializable id = session.save(lib);
			System.out.println("Creada cancion con id: " + id);

		} catch (Exception e) {
			System.out.println("Excepcion: No se puede actualizar la Base de Datos Libro...");
			e.printStackTrace();
		}

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
		System.out.println("Commit de la transaction y cierre de sesion");

	}

	public static void actualizarLibro(int id) {

		Session session = sessionConnection();
		session.beginTransaction();

		Scanner teclado = new Scanner(System.in);
		try {
			Libro actualizaLibro = (Libro) session.load(Libro.class, id);
			System.out.print("Introduce el Titulo: ");
			String titulo = teclado.nextLine();
			actualizaLibro.setTitulo(titulo);
			System.out.print("Introduce el Autor: ");
			String autor = teclado.nextLine();
			actualizaLibro.setTitulo(autor);
			System.out.print("Introduce el Año Nacimiento: ");
			String aNacimiento = teclado.nextLine();
			actualizaLibro.setTitulo(aNacimiento);
			System.out.print("Introduce el Año Publicacion: ");
			String aPublicacion = teclado.nextLine();
			actualizaLibro.setTitulo(aPublicacion);
			System.out.print("Introduce el nombre de la Editorial: ");
			String editorial = teclado.nextLine();
			actualizaLibro.setTitulo(editorial);
			System.out.print("Introduce el numero de paginas: ");
			String numPaginas = teclado.nextLine();
			actualizaLibro.setTitulo(numPaginas);

			session.update(actualizaLibro);

		} catch (Exception e) {
			System.out.println("Excepcion: No se puede actualizar la Base de Datos Libro...");
			e.printStackTrace();
		}

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
		System.out.println("Commit de la transaction y cierre de sesion");
		teclado.close();
	}

	public static void borrarLibro(int id) {
		Session session = sessionConnection();
		session.beginTransaction();

		try {
			Libro libro = new Libro();
			libro.setId(id);
			session.delete(libro);
			System.out.println("Libro borrado con Id " + id + "...");

		} catch (Exception e) {
			System.out.println("Excepcion: No se puede actualizar la Base de Datos Libro...");
			e.printStackTrace();
		}

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
		System.out.println("Commit de la transaction y cierre de sesion");

	}

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		int id;

		while (opcion != 6) {
			System.out.println("\n\n1. Mostrar todos los titulos de la biblioteca");
			System.out.println("2. Mostrar informacion detallada de un libro");
			System.out.println("3. Crear nuevo libro");
			System.out.println("4. Actualizar libro");
			System.out.println("5. Borrar libro");
			System.out.println("6. Cerrar la biblioteca");
			System.out.print("\n >>> Elegir una opcion: ");
			opcion = Integer.parseInt(teclado.next());

			switch (opcion) {
			case 1:
				mostrarTodos();
				break;
			case 2:
				System.out.print(" >> Indica el numero del libro a mostrar: ");
				id = Integer.parseInt(teclado.next());
				mostrarLibro(id);
				break;
			case 3:
				crearLibro();
				break;
			case 4:
				System.out.print(" >> Indica el numero del libro a actualizar: ");
				id = Integer.parseInt(teclado.next());
				actualizarLibro(id);
				break;
			case 5:
				System.out.print(" >> Indica el numero del libro a borrar: ");
				id = Integer.parseInt(teclado.next());
				borrarLibro(id);
				break;
			case 6:
				System.out.println("Salida de la Aplicacion...");
				teclado.close();
				break;
			default:
				break;
			}
		}
	}

}
