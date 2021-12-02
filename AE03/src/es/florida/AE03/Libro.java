/**
 * Creacion del constructor de las variables con sus correspondientes getters y setters
 */
package es.florida.AE03;

public class Libro {

	String identificador, titulo, autor, aPublicacion, editorial, numPaginas;

	Libro() {
	};

	Libro(String identificador, String titulo, String autor, String aPublicacion, String editorial, String numPaginas) {
		this.identificador = identificador;
		this.titulo = titulo;
		this.autor = autor;
		this.aPublicacion = aPublicacion;
		this.editorial = editorial;
		this.numPaginas = numPaginas;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getaPublicacion() {
		return aPublicacion;
	}

	public void setaPublicacion(String aPublicacion) {
		this.aPublicacion = aPublicacion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getnumPaginas() {
		return numPaginas;
	}

	public void setnumPaginas(String numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String toString() {
		String infoCompleta = "\nIdentificador: " + identificador + "\nTitulo: " + titulo + "\nAutor: "
				+ autor + "\nAño Publicacion: " + aPublicacion + "\nEditorial: " + editorial + "\nNumero Paginas: "
				+ numPaginas;
		return infoCompleta;
	}

}
