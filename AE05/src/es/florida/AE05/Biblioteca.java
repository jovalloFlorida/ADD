/**
 * Proyecto Java que gestione objetos libros y asegure su persistencia en la base de datos relacional MySQL mediante Hibernate.
 */
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

	/**
	 * Metodo para la Carga de la configuracion crea un session factory de
	 * hibernate, donde retorna la session
	 * 
	 * @return
	 */
	public static Session sessionConnection() {
		// Carga la configuracion crea un session factory
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Libro.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);

		// Abre una nueva session de la session factory
		Session session = sessionFactory.openSession();
		return session;
	}

	/**
	 * Metodo para mostrar por pantalla todos los libros de la base de Datos,
	 * mostrando solo el Id y el Titulo del libro.
	 */
	public static void mostrarTodos() {
		Session session = sessionConnection();
		session.beginTransaction();

		List listaLibros = new ArrayList();
		listaLibros = session.createQuery("FROM Libro").list();
		System.out.println("\n <<< Listado de la Base de Datos de la Biblioteca >>>\n");
		for (Object obj : listaLibros) {
			Libro lib = (Libro) obj;
			System.out.println("Libro -> Id: " + lib.getId() + ", Titulo: " + lib.getTitulo());
		}

		System.out.println("\n >>> Mostrado el listado de la Base de Datos de la Biblioteca...");

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();

	}

	/**
	 * Metodo que enviandole el id muestre la informacion detallada del libro
	 * 
	 * @param id
	 */
	public static void mostrarLibro(int id) {
		Session session = sessionConnection();
		session.beginTransaction();

		Libro libro = (Libro) session.get(Libro.class, id);
		if (libro == null) {
			System.out.println("\nNo hay ningun libro en la Base de Datos con el id: " + id);
		} else {
			System.out.println("\n" + libro.toString());
		}

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Metodo para la creacion de un nuevo Libro en la Base de Datos
	 */
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
			System.out.println("\nCreado Libro en la Base de Datos Id: " + id);

		} catch (Exception e) {
			System.out.println("\nExcepcion: No se puede actualizar la Base de Datos Libro...");
			// e.printStackTrace();
		}

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Metodo que tras pasarle el id, modificar los atributos de un libro
	 * @param id
	 */
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
			actualizaLibro.setAutor(autor);
			System.out.print("Introduce el Año Nacimiento: ");
			String aNacimiento = teclado.nextLine();
			actualizaLibro.setNacimiento(aNacimiento);
			System.out.print("Introduce el Año Publicacion: ");
			String aPublicacion = teclado.nextLine();
			actualizaLibro.setPublicacion(aPublicacion);
			System.out.print("Introduce el nombre de la Editorial: ");
			String editorial = teclado.nextLine();
			actualizaLibro.setEditorial(editorial);
			System.out.print("Introduce el numero de paginas: ");
			String numPaginas = teclado.nextLine();
			actualizaLibro.setNumpaginas(numPaginas);

			session.update(actualizaLibro);
			System.out.println("\nModificado Libro en la Base de Datos Id: " + id);

		} catch (Exception e) {
			System.out.println("\nExcepcion: No existe o no se puede actualizar el Libro con el Id: " + id);
			// e.printStackTrace();
		}

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Metodo a partir del id introducido, borrar el libro de la Base de Datos
	 * @param id
	 */
	public static void borrarLibro(int id) {
		Session session = sessionConnection();
		session.beginTransaction();

		try {
			Libro libro = new Libro();
			libro.setId(id);
			session.delete(libro);
			System.out.println("\nLibro borrado con Id " + id + "...");

		} catch (Exception e) {
			System.out.println("\nExcepcion: No se puede borrar de la Base de Datos el Libro... " + id);
			// e.printStackTrace();
		}

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Metodo main en el que muetra un menu con las funcionalidades de la aplicacion
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		int id;
		try {
			while (opcion != 6) {
				System.out.println("\n\n1. Mostrar todos los titulos de la Biblioteca");
				System.out.println("2. Mostrar informacion detallada de un Libro");
				System.out.println("3. Crear nuevo Libro");
				System.out.println("4. Actualizar Libro");
				System.out.println("5. Borrar Libro");
				System.out.println("6. Cerrar la Biblioteca");
				System.out.print("\n >>> Elegir una opcion: ");
				opcion = Integer.parseInt(teclado.next());

				switch (opcion) {
				case 1:
					mostrarTodos();
					break;
				case 2:
					System.out.print(">>>> Indica el numero del Libro a mostrar: ");
					id = Integer.parseInt(teclado.next());
					mostrarLibro(id);
					break;
				case 3:
					crearLibro();
					break;
				case 4:
					System.out.print(">>> Indica el numero del Libro a actualizar: ");
					id = Integer.parseInt(teclado.next());
					actualizarLibro(id);
					break;
				case 5:
					System.out.print(">>> Indica el numero del Libro a borrar: ");
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

		} catch (Exception e) {
			System.out.println("\n <<< Excepcion: Opcion no Admitida >>>");
			// e.printStackTrace();
		}
	}

}
