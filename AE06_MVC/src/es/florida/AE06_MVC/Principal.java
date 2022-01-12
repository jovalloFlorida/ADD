package es.florida.AE06_MVC;

public class Principal {

	public static void main(String[] args) {

		try {

			// Ejecución del modelo vista controlador (el controlador recibe la "session"
			// por parámetro)
			Vista vista = new Vista();
			//Biblioteca biblioteca = new Biblioteca();
			Controlador controlador = new Controlador(vista);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
