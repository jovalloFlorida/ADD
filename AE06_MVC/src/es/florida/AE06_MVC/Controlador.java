package es.florida.AE06_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.bson.Document;
import com.mongodb.client.MongoCollection;

public class Controlador {

	private Vista vista;
	private ActionListener actionListenerMostrarTodos, actionListenerMostrarLibro, actionListenercrearLibro,
			actionListenerModificar, actionListenerBorrarLibro, actionListenerSalir;
	String linea;

	/**
	 * Metodo Controlador que carga la interfaz e instancia los métodos
	 * initEventHandlers() y control()
	 * 
	 * @param vista
	 * @param biblioteca
	 * @param coleccion
	 */
	public Controlador(Vista vista, Biblioteca biblioteca, MongoCollection<Document> coleccion) {
		this.vista = vista;
		initEventHandlers();
		control();
	}

	/**
	 * Metodo Control que desarrolla actionListeners
	 */
	public void control() {

		/**
		 * Biblioteca.mostrarTodos()
		 */
		actionListenerMostrarTodos = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				linea = Biblioteca.mostrarTodos();
				vista.gettextArea_Texto().append("\n <<< Listado base de datos mostrando Id y Titulo del Libro >>>\n");
				vista.gettextArea_Texto().append("\n" + linea);
			}
		};
		vista.getbtnMostrar().addActionListener(actionListenerMostrarTodos);

		/**
		 * Biblioteca.mostrarLibro(identificador);
		 */
		actionListenerMostrarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					JFrame jFrame = new JFrame();
					String id = JOptionPane.showInputDialog(jFrame, "Indica el numero Id del Libro a mostrar: ");
					int identificador = Integer.parseInt(id);
					if (id != null) {
						linea = Biblioteca.mostrarLibro(identificador);
						vista.gettextArea_Texto().append("\n <<< Libro en la Base de Datos >>>\n");
						vista.gettextArea_Texto().append("\n" + linea);
					}
				} catch (Exception e) {
					vista.gettextArea_Texto()
							.append("\n <<< Debes introducir el Id del Libro para poderlo mostrar... >>>\n");
				}
			}
		};
		vista.getbtnConsultar().addActionListener(actionListenerMostrarLibro);

		/**
		 * Biblioteca.crearLibro(titulo, autor, aNacimiento, aPublicacion, editorial,
		 * numPaginas);
		 */
		actionListenercrearLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFrame jFrame = new JFrame();
				String titulo = JOptionPane.showInputDialog(jFrame, "Introduce el Titulo: ");
				String autor = JOptionPane.showInputDialog(jFrame, "Introduce el Autor: ");
				String aNacimiento = JOptionPane.showInputDialog(jFrame, "Introduce la Fecha de Nacimiento: ");
				String aPublicacion = JOptionPane.showInputDialog(jFrame, "Introduce la Fecha de Publicación: ");
				String editorial = JOptionPane.showInputDialog(jFrame, "Introduce la Editorial: ");
				String numPaginas = JOptionPane.showInputDialog(jFrame, "Introduce Numero Paginas: ");
				linea = Biblioteca.crearLibro(titulo, autor, aNacimiento, aPublicacion, editorial, numPaginas);
				vista.gettextArea_Texto().append("\n" + linea);
			}
		};
		vista.getbtnAnyadir().addActionListener(actionListenercrearLibro);

		/**
		 * Biblioteca.borrarLibro(identificador)
		 */
		actionListenerBorrarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					JFrame jFrame = new JFrame();
					String id = JOptionPane.showInputDialog(jFrame, "Indica el numero Id del Libro a borrar: ");

					if (id != null) {
						int identificador = Integer.parseInt(id);
						linea = Biblioteca.borrarLibro(identificador);
						vista.gettextArea_Texto().append("\n" + linea);
					}
				} catch (Exception e) {
					vista.gettextArea_Texto()
							.append("\n <<< Debes introducir el Id del Libro para poderlo mostrar... >>>\n");
				}
			}
		};

		vista.getbtnBorrar().addActionListener(actionListenerBorrarLibro);

		/**
		 * Biblioteca.actualizarLibro(identificador, titulo, autor, aNacimiento,
		 * aPublicacion,editorial, numPaginas)
		 */
		actionListenerModificar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					JFrame jFrame = new JFrame();
					String id = JOptionPane.showInputDialog(jFrame, "Indica el numero Id del Libro a actualizar:");
					String titulo = JOptionPane.showInputDialog(jFrame, "Introduce el Titulo: ");
					String autor = JOptionPane.showInputDialog(jFrame, "Introduce el Autor: ");
					String aNacimiento = JOptionPane.showInputDialog(jFrame, "Introduce la Fecha de Nacimiento: ");
					String aPublicacion = JOptionPane.showInputDialog(jFrame, "Introduce la Fecha de Publicación: ");
					String editorial = JOptionPane.showInputDialog(jFrame, "Introduce la Editorial: ");
					String numPaginas = JOptionPane.showInputDialog(jFrame, "Introduce Numero Paginas: ");

					int identificador = Integer.parseInt(id);

					linea = Biblioteca.actualizarLibro(identificador, titulo, autor, aNacimiento, aPublicacion,
							editorial, numPaginas);
					vista.gettextArea_Texto().append("\n" + linea);
				} catch (Exception e) {
					vista.gettextArea_Texto()
							.append("\n <<< Debes introducir el Id del Libro para poderlo mostrar... >>>\n");
				}
			}
		};
		vista.getbtnModificar().addActionListener(actionListenerModificar);

		/**
		 * Boton de Salida de Aplicacion
		 */
		actionListenerSalir = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Biblioteca.mongoDBConnectionClose();
				System.exit(0);
			}
		};
		vista.getbtnGuardar().addActionListener(actionListenerSalir);

	}

	/**
	 * Metodo initEventHandlers(), Controlador de eventos.
	 */
	public void initEventHandlers() {

		vista.getbtnMostrar().addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		vista.getbtnConsultar().addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		vista.getbtnAnyadir().addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		vista.getbtnBorrar().addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		vista.getbtnModificar().addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		vista.getbtnGuardar().addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

	}

}