package es.florida.AE02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase Modelo
 * 
 * @author Jose Valverde
 *
 */
public class Modelo {

	private String fichero_lectura;
	private String fichero_escritura;

	public Modelo() {
		fichero_lectura = "AE02_T1_2_Streams_Groucho.txt";
		fichero_escritura = "AE02_T1_2_Streams_Groucho2.txt";
	}

	/**
	 * Metodo que devuelve un Array de strings con el contenido del fichero
	 * 
	 * @param fichero
	 * @return
	 */
	public ArrayList<String> contenidoFichero(String fichero) {
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		File f = new File(fichero);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				contenidoFichero.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return contenidoFichero;
	}

	/**
	 * Metodo que devuelve el nombre del fichero de lectura y escritura
	 * 
	 * @return
	 */
	public String ficheroEscritura() {
		return fichero_escritura;
	}

	public String ficheroLectura() {
		return fichero_lectura;
	}

	/**
	 * Metodo donde se le pasa el texto a buscar (textoBuscar) en el contenido del
	 * fichero y cuenta el numero de veces que ha aparecido dicho texto.
	 * 
	 * @param textoBuscar
	 * @return
	 */
	public int buscarTexto(String textoBuscar) {

		int contador = 0;

		try {
			FileReader fr = new FileReader(fichero_lectura);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				while (linea.indexOf(textoBuscar) > -1) {
					linea = linea.substring(linea.indexOf(textoBuscar) + textoBuscar.length(), linea.length());
					contador++;
				}
				linea = br.readLine();
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return contador;
	}

	/**
	 * Metodo que se le pasa el texto a buscar y el texto a reemplazar. Ademas crea
	 * un fichero con el textos sustituido a la vez que lo sacamos en el componente
	 * textArea_Original.
	 * 
	 * @param textoReemplazar
	 * @param textoBuscar
	 */
	public void reemplazarTexto(String textoReemplazar, String textoBuscar) {
		File f1 = new File(ficheroLectura());
		File f2 = new File(ficheroEscritura());
		try {
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(f2);
			BufferedWriter bw = new BufferedWriter(fw);
			String linea = br.readLine();
			while (linea != null) {
				bw.write(linea.replace(textoBuscar, textoReemplazar));
				bw.newLine();
				linea = br.readLine();
			}
			br.close();
			fr.close();
			bw.close();
			br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
