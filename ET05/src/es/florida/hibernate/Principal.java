package es.florida.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Principal {

	public static void main(String[] args) {

		// Carga la configuraciony crea un sessionfactory
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Cancion.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);

		// Abre una nueva sessionde la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Aquí las operacionesCRUD (crear, leer, actualizar, borrar)

		// Persistencia de 2 Objetos tipo Cancion
		Cancion cancion1 = new Cancion("La Barbacoa", "Georgie Dann", 2006, "OGG");
		session.persist(cancion1);
		Cancion cancion2 = new Cancion("Cornfield chase", "Hans Zimmer", 2014, "RAW");
		Serializable id = session.save(cancion2);
		System.out.println("Creada cancion con id: " + id);

		// Carga de Objetos de la BBDD
		Cancion cancion3 = (Cancion) session.get(Cancion.class, 1);
		if (cancion3 == null) {
			System.out.println("No hay cancion con Id 1");
		} else {
			System.out.println("Titulo de la cancion: " + cancion3.getTitulo());
		}

		// Recuperar Lista de Objetos
		List listaCanciones = new ArrayList();
		listaCanciones = session.createQuery("FROM Cancion").list();
		for (Object obj : listaCanciones) {
			Cancion can = (Cancion) obj;
			System.out.println(can.toString());
		}

		// Intentar cargar un Objeto Cancion con id que no exista
		try {
			Cancion cancion4 = (Cancion) session.get(Cancion.class, 4);
			System.out.println("Titulo de la cancion 4: " + cancion4.getTitulo());
		} catch (Exception e) {
			System.out.println("Excepcion: No se encuentra la cancion con el id 4 ");
			e.printStackTrace();
		}

		// Actualiza una instancia cargada en la sesion
		try {
			Cancion cancion5 = (Cancion) session.load(Cancion.class, 5);
			cancion5.setAnyo(2010);
			cancion5.setFormato("MP3");
			session.update(cancion5);
			System.out.println("Actualizados datos de la cancion 5: " + cancion5.getTitulo());
		} catch (Exception e) {
			System.out.println("Excepcion: No se encuentra la cancion con el id 5 ");
			e.printStackTrace();
		}

		// Borrar un objeto
		try {
			Cancion cancion7 = new Cancion();
			cancion7.setId(7);
			session.delete(cancion7);
			System.out.println("Borrado cancion 7");
		} catch (Exception e) {
			System.out.println("Excepcion: No se encuentra la cancion con el id 5 ");
			e.printStackTrace();
		}

		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
		System.out.println("Commit de la transaction y cierre de sesion");
	}

}
