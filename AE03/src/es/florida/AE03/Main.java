/**
 * Clase para lanzar el programa
 */
package es.florida.AE03;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		Biblioteca biblioteca = new Biblioteca();
		biblioteca.menuPrincipal();

	}

}
