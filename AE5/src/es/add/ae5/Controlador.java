package es.add.ae5;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hibernate.Session;

public class Controlador {

	private Vista vista;
	private ActionListener actionListenerMostrar, actionListenerConsultaLibro, actionListenerAnyadir, 
	actionListenerModificar, actionListenerBorrar, actionListenerGuardar;
	String linea;
	
	//M�todo: controlador
		//Descripci�n: carga la interfaz e instancia los m�todos initEventHandlers() y control()
		//Par�metros de entrada: no.
		//Par�metros de salida: no.
	public Controlador(Vista vista, Biblioteca biblioteca, Session session) {
		this.vista = vista;
		initEventHandlers();
		control(session);
		//vista.gettextArea_Texto().append("Leer es bueno. �En qu� te podemos ayudar?");
	}


	//M�todo: control.
		//Descripci�n: desarrolla actionListeners
		//Par�metros de entrada: no.
		//Par�metros de salida: no.
	public void control(Session session) {
		
		actionListenerMostrar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				linea = Biblioteca.mostrarBD(session);
				vista.gettextArea_Texto().append("\n" + " <<< Listado base de datos completa >>>\n");
				vista.gettextArea_Texto().append("\n" + linea);
			}
		};
		
		vista.getbtnMostrar().addActionListener(actionListenerMostrar);

		
		actionListenerConsultaLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFrame jFrame = new JFrame();
		        String id = JOptionPane.showInputDialog(jFrame, "Introduce la ID del libro que deseas consultar");
				
		        int identificador = Integer.parseInt(id);
		        
		        if (id != null) {
		        	linea = Biblioteca.consultarLibro(session, identificador);
					vista.gettextArea_Texto().append("\n" + "\nLibro consultado:");
					vista.gettextArea_Texto().append("\n" + linea);
		        } 
			}
		};
		
		vista.getbtnConsultar().addActionListener(actionListenerConsultaLibro);
		
		
		actionListenerAnyadir = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFrame jFrame = new JFrame();
		        String titulo = JOptionPane.showInputDialog(jFrame, "T�tulo: ");
		        String autor = JOptionPane.showInputDialog(jFrame, "Autor: ");
		        String fechaNac = JOptionPane.showInputDialog(jFrame, "Fecha de nacimiento: ");
		        String fechaPub = JOptionPane.showInputDialog(jFrame, "Fecha de publicaci�n: ");
		        String editorial = JOptionPane.showInputDialog(jFrame, "Editorial: ");
		        String pags = JOptionPane.showInputDialog(jFrame, "P�ginas: ");
				linea = Biblioteca.anyadirLibro(session, titulo, autor, fechaNac, fechaPub, editorial, pags);
				vista.gettextArea_Texto().append("\n" + linea);
			}
		};
		
		vista.getbtnAnyadir().addActionListener(actionListenerAnyadir);
		
		
		actionListenerBorrar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFrame jFrame = new JFrame();
		        String id = JOptionPane.showInputDialog(jFrame, "Introduce la ID del libro que deseas borrar");
		       
		        if (id != null) {
		        	int identificador = Integer.parseInt(id);
		        	linea = Biblioteca.borrarLibro(session, identificador);
					vista.gettextArea_Texto().append("\n" + linea);
		        }
			}
		};
		
		vista.getbtnBorrar().addActionListener(actionListenerBorrar);
		
		
		actionListenerModificar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFrame jFrame = new JFrame();
				String id = JOptionPane.showInputDialog(jFrame, "Introduce la ID del libro que deseas modificar");
		        String titulo = JOptionPane.showInputDialog(jFrame, "Nuevo t�tulo: ");
		        String autor = JOptionPane.showInputDialog(jFrame, "Nuevo autor: ");
		        String fechaNac = JOptionPane.showInputDialog(jFrame, "Nuevo A�o de nacimiento: ");
		        String fechaPub = JOptionPane.showInputDialog(jFrame, "Nuevo A�o de publicaci�n: ");
		        String editorial = JOptionPane.showInputDialog(jFrame, "Nueva Editorial: ");
		        String pags = JOptionPane.showInputDialog(jFrame, "Nuevo N� de p�ginas: ");
		        
		        int identificador = Integer.parseInt(id);
		        
				linea = Biblioteca.modificarLibro(session, identificador, titulo, autor, fechaNac, fechaPub, editorial, pags);
				vista.gettextArea_Texto().append("\n" + linea);
			}
		};
		
		vista.getbtnModificar().addActionListener(actionListenerModificar);
		
		
		actionListenerGuardar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Biblioteca.guardarBD(session);
				System.exit(0);
			}
		};
		
		vista.getbtnGuardar().addActionListener(actionListenerGuardar);
		
		
	}

	
	//M�todo: initEventHandlers.
		//Descripci�n: Controlador de eventos.
		//Par�metros de entrada: no.
		//Par�metros de salida: no.
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