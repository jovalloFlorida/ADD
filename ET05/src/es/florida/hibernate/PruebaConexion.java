package es.florida.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PruebaConexion {

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

		System.out.println("\nConexion realizada correctamente...\n");
		
		// Commit de la transacción y cierra sesión
		session.getTransaction().commit();
		session.close();
		System.out.println("\nCommit de la transaction y cierre de sesion");

	}

}
