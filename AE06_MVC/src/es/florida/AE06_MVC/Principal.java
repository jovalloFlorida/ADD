package es.florida.AE06_MVC;

public class Principal {

	public static void main(String[] args) {

		try {

			// Ejecuci�n del modelo vista controlador (el controlador recibe la "session"
			// por par�metro)
			Vista vista = new Vista();
			//Biblioteca biblioteca = new Biblioteca();
			Controlador controlador = new Controlador(vista);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
