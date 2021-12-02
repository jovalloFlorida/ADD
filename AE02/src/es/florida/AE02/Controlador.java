package es.florida.AE02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase donde llamamos al resto de clases y controlamos en modo ejecucion
 * 
 * @author Jose Valverde
 *
 */
public class Controlador {

	private Modelo modelo;
	private Vista vista;
	private ActionListener actionListenerBuscar;
	private ActionListener actionListenerReemplazar;
	private String ficheroLectura, ficheroEscritura;

	/**
	 * Constructor clase Controlador
	 * 
	 * @param modelo
	 * @param vista
	 */
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		control();
	}

	/*
	 * Metodo donde controlamos los objetos creados donde actuara sobre los botones
	 * creados en la clase Vista Metodo
	 */
	private void control() {
		ficheroLectura = modelo.ficheroLectura();
		ficheroEscritura = modelo.ficheroEscritura();

		mostrarFichero(ficheroLectura, 1);
		actionListenerBuscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String textoBuscar = vista.getTextFieldBuscar().getText();
				modelo.buscarTexto(textoBuscar);
				JOptionPane.showMessageDialog(null, "La cantidad de la palabra " + "'" + textoBuscar + "'"
						+ " ha aparecido " + modelo.buscarTexto(textoBuscar) + " veces");

			}
		};
		vista.getBtnBuscar().addActionListener(actionListenerBuscar);

		actionListenerReemplazar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String textoBuscar = vista.getTextFieldBuscar().getText();
				String textoReemplazar = vista.getTextFieldReemplazar().getText();
				modelo.reemplazarTexto(textoReemplazar, textoBuscar);
				mostrarFichero(ficheroEscritura, 2);

			}
		};
		vista.getBtnReemplazar().addActionListener(actionListenerReemplazar);
	}

	/**
	 * Metodo para mostrar el contenido de un fichero. Donde le pasamos el parametro
	 * Fichero(donde le indicamos el fichero a tratar) y numeroTextArea(donde
	 * indicamos en que textArea mostrar la informacion del fichero)
	 * 
	 * @param Fichero
	 * @param numeroTextArea
	 */
	private void mostrarFichero(String Fichero, int numeroTextArea) {
		ArrayList<String> arrayLineas = modelo.contenidoFichero(Fichero);
		for (String linea : arrayLineas) {
			if (numeroTextArea == 1)
				vista.getTextAreaOriginal().append(linea + "\n");
			else
				vista.getTextAreaModificado().append(linea + "\n");
		}
	}

}
