package es.florida.AE06_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class Controlador {

	private Vista vista;
	private ActionListener actionListenerMostrar, actionListenerConsultaLibro, actionListenerAnyadir,
			actionListenerModificar, actionListenerBorrar, actionListenerGuardar;
	String linea;

	// Método: controlador
	// Descripción: carga la interfaz e instancia los métodos initEventHandlers() y
	// control()
	// Parámetros de entrada: no.
	// Parámetros de salida: no.
	public Controlador(Vista vista, Biblioteca biblioteca, MongoCollection<Document> coleccion) {
		this.vista = vista;
		initEventHandlers();
		control();
	}

	// Método: control.
	// Descripción: desarrolla actionListeners
	// Parámetros de entrada: no.
	// Parámetros de salida: no.
	public void control() {

		/**
		 * Biblioteca.mostrarTodos()
		 */
		actionListenerMostrar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				linea = Biblioteca.mostrarTodos();
				vista.gettextArea_Texto().append("\n <<< Listado base de datos completa >>>\n");
				vista.gettextArea_Texto().append("\n" + linea);
			}
		};
		vista.getbtnMostrar().addActionListener(actionListenerMostrar);

		/**
		 * Biblioteca.mostrarLibro(identificador);
		 */
		actionListenerConsultaLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFrame jFrame = new JFrame();
				String id = JOptionPane.showInputDialog(jFrame, "Indica el numero Id del Libro a mostrar: ");
				int identificador = Integer.parseInt(id);
				if (id != null) {
					linea = Biblioteca.mostrarLibro(identificador);
					vista.gettextArea_Texto().append("\n <<< Libro en la Base de Datos >>>\n");
					vista.gettextArea_Texto().append("\n" + linea);
				}
			}
		};
		vista.getbtnConsultar().addActionListener(actionListenerConsultaLibro);

		/**
		 * Biblioteca.crearLibro(titulo, autor, aNacimiento, aPublicacion, editorial,
		 * numPaginas);
		 */
		actionListenerAnyadir = new ActionListener() {
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
		vista.getbtnAnyadir().addActionListener(actionListenerAnyadir);

		/**
		 * Biblioteca.borrarLibro(identificador)
		 */
		actionListenerBorrar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFrame jFrame = new JFrame();
				String id = JOptionPane.showInputDialog(jFrame, "Indica el numero Id del Libro a borrar: ");

				if (id != null) {
					int identificador = Integer.parseInt(id);
					linea = Biblioteca.borrarLibro(identificador);
					vista.gettextArea_Texto().append("\n" + linea);
				}
			}
		};

		vista.getbtnBorrar().addActionListener(actionListenerBorrar);

		/**
		 * 
		 */
		actionListenerModificar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFrame jFrame = new JFrame();
				String id = JOptionPane.showInputDialog(jFrame, "Indica el numero Id del Libro a actualizar:");
				String titulo = JOptionPane.showInputDialog(jFrame, "Introduce el Titulo: ");
				String autor = JOptionPane.showInputDialog(jFrame, "Introduce el Autor: ");
				String aNacimiento = JOptionPane.showInputDialog(jFrame, "Introduce la Fecha de Nacimiento: ");
				String aPublicacion = JOptionPane.showInputDialog(jFrame, "Introduce la Fecha de Publicación: ");
				String editorial = JOptionPane.showInputDialog(jFrame, "Introduce la Editorial: ");
				String numPaginas = JOptionPane.showInputDialog(jFrame, "Introduce Numero Paginas: ");

				int identificador = Integer.parseInt(id);

				linea = Biblioteca.actualizarLibro(identificador, titulo, autor, aNacimiento, aPublicacion, editorial,
						numPaginas);
				vista.gettextArea_Texto().append("\n" + linea);
			}
		};
		vista.getbtnModificar().addActionListener(actionListenerModificar);

		/**
		 * Boton de Salida de Aplicacion
		 */
		actionListenerGuardar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Biblioteca.mongoDBConnectionClose();
				System.exit(0);
			}
		};
		vista.getbtnGuardar().addActionListener(actionListenerGuardar);

	}

	// Método: initEventHandlers.
	// Descripción: Controlador de eventos.
	// Parámetros de entrada: no.
	// Parámetros de salida: no.
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