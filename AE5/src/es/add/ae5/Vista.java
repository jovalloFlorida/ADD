package es.add.ae5;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

public class Vista {

	private JFrame frame;
	private JButton btnMostrar;
	private JButton btnConsultar;
	private JButton btnAnyadir;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JButton btnGuardar;
	private JTextField textField_Mostrar;
	private JTextArea textArea_Texto;

	
	public Vista() {
		inicialize();
	}

	
	public void inicialize() {
		frame = new JFrame();
		frame.setBounds(300, 300, 950, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setTitle("Biblioteca P?blica AE05");

		JScrollPane scrollPane_Original = new JScrollPane();
		scrollPane_Original.setBounds(10, 10, 920, 230);
		frame.getContentPane().add(scrollPane_Original);

		textArea_Texto = new JTextArea();
		textArea_Texto.setLineWrap(true);
		textArea_Texto.setRows(30);
		textArea_Texto.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane_Original.setColumnHeaderView(textArea_Texto);
		scrollPane_Original.getViewport().setView(textArea_Texto);

		
		btnMostrar = new JButton("Mostrar BD");
		btnMostrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnMostrar.setBounds(20, 250, 120, 27);
		frame.getContentPane().add(btnMostrar);

		btnConsultar = new JButton("Consultar libro");
		btnConsultar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConsultar.setBounds(20, 324, 120, 27);
		frame.getContentPane().add(btnConsultar);
		
		btnAnyadir = new JButton("A?adir libro");
		btnAnyadir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAnyadir.setBounds(20, 287, 120, 27);
		frame.getContentPane().add(btnAnyadir);
		
		btnModificar = new JButton("Modificar libro");
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnModificar.setBounds(160, 287, 120, 27);
		frame.getContentPane().add(btnModificar);
		
		btnBorrar = new JButton("Borrar libro");
		btnBorrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBorrar.setBounds(160, 324, 120, 27);
		frame.getContentPane().add(btnBorrar);
		
		btnGuardar = new JButton("Salir");
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGuardar.setBounds(779, 339, 120, 27);
		frame.getContentPane().add(btnGuardar);

		this.frame.setVisible(true);
	}

	
	public JButton getbtnMostrar() {
		return btnMostrar;
	}

	public JButton getbtnConsultar() {
		return btnConsultar;
	}

	public JButton getbtnAnyadir() {
		return btnAnyadir;
	}
	
	public JButton getbtnModificar() {
		return btnModificar;
	}
	
	public JButton getbtnBorrar() {
		return btnBorrar;
	}
	
	public JButton getbtnGuardar() {
		return btnGuardar;
	}

	public JTextField gettextField_Mostrar() {
		return textField_Mostrar;
	}
	
	public JTextArea gettextArea_Texto() {
		return textArea_Texto;
	}

}