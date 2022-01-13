package es.florida.AE06_MVC;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class Vista {

	private JFrame frame;
	private JButton btnMostrarBiblioteca;
	private JButton btnMostrar;
	private JButton btnCrear;
	private JButton btnActualizar;
	private JButton btnBorrar;
	private JButton btnSalir;
	private JTextField textField_Mostrar;
	private JTextArea textArea_Texto;

	
	public Vista() {
		inicialize();
	}

	public void inicialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 743, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setTitle("Gestion Biblioteca. AE06 MongoDB");

		JScrollPane scrollPane_Original = new JScrollPane();
		scrollPane_Original.setBounds(10, 10, 521, 426);
		frame.getContentPane().add(scrollPane_Original);

		textArea_Texto = new JTextArea();
		textArea_Texto.setLineWrap(true);
		textArea_Texto.setRows(30);
		textArea_Texto.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane_Original.setColumnHeaderView(textArea_Texto);
		scrollPane_Original.getViewport().setView(textArea_Texto);

		
		btnMostrarBiblioteca = new JButton("Mostrar Biblioteca");
		btnMostrarBiblioteca.setFont(new Font("Arial", Font.PLAIN, 12));
		btnMostrarBiblioteca.setBounds(563, 60, 130, 28);
		frame.getContentPane().add(btnMostrarBiblioteca);

		btnMostrar = new JButton("Mostrar Libro");
		btnMostrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnMostrar.setBounds(563, 97, 130, 28);
		frame.getContentPane().add(btnMostrar);
		
		btnCrear = new JButton("Crear Libro");
		btnCrear.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCrear.setBounds(563, 134, 130, 28);
		frame.getContentPane().add(btnCrear);
		
		btnActualizar = new JButton("Actualizar Libro");
		btnActualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnActualizar.setBounds(563, 171, 130, 28);
		frame.getContentPane().add(btnActualizar);
		
		btnBorrar = new JButton("Borrar libro");
		btnBorrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBorrar.setBounds(563, 208, 130, 28);
		frame.getContentPane().add(btnBorrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalir.setBounds(563, 390, 130, 28);
		frame.getContentPane().add(btnSalir);

		this.frame.setVisible(true);
	}

	
	public JButton getbtnMostrar() {
		return btnMostrarBiblioteca;
	}

	public JButton getbtnConsultar() {
		return btnMostrar;
	}

	public JButton getbtnAnyadir() {
		return btnCrear;
	}
	
	public JButton getbtnModificar() {
		return btnActualizar;
	}
	
	public JButton getbtnBorrar() {
		return btnBorrar;
	}
	
	public JButton getbtnGuardar() {
		return btnSalir;
	}

	public JTextField gettextField_Mostrar() {
		return textField_Mostrar;
	}
	
	public JTextArea gettextArea_Texto() {
		return textArea_Texto;
	}

}