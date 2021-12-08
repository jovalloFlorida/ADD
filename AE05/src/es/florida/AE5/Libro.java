package es.florida.AE5;

public class Libro {
	
	private int id;
	private String titulo;
	private String autor;
	private String nacimiento;
	private String publicacion;
	private String editorial;
	private String numpaginas;
	
	public Libro() {
	
	}

	public Libro(int id, String titulo, String autor, String nacimiento, String publicacion, String editorial,
			String numpaginas) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.nacimiento = nacimiento;
		this.publicacion = publicacion;
		this.editorial = editorial;
		this.numpaginas = numpaginas;
	}

	public Libro(String titulo, String autor, String nacimiento, String publicacion, String editorial,
			String numpaginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.nacimiento = nacimiento;
		this.publicacion = publicacion;
		this.editorial = editorial;
		this.numpaginas = numpaginas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getNumpaginas() {
		return numpaginas;
	}

	public void setNumpaginas(String numpaginas) {
		this.numpaginas = numpaginas;
	}

	public String toString() {
		return "Libro -> Id: " + getId() + ", Titulo: " + getTitulo() + ", Autor: " + getAutor()
				+ ", Fecha Nacimiento: " + getNacimiento() + ", Año Publicacion: " + getPublicacion()
				+ ", Editorial: " + getEditorial() + ", Numero Paginas: " + getNumpaginas();
	}
	
	
	
	
	

}
