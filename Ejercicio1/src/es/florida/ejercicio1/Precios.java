package es.florida.ejercicio1;

public class Precios {
	
	private int id;
	private String item;
	private int precio;
	private int precioOferta;
	private String saldo;
	
	public Precios() {
		
	}

	public Precios(int id, String item, int precio, int precioOferta, String saldo) {
		this.id = id;
		this.item = item;
		this.precio = precio;
		this.precioOferta = precioOferta;
		this.saldo = saldo;
	}
	
	public Precios(String item, int precio, int precioOferta, String saldo) {
		this.item = item;
		this.precio = precio;
		this.precioOferta = precioOferta;
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPrecioOferta() {
		return precioOferta;
	}

	public void setPrecioOferta(int precioOferta) {
		this.precioOferta = precioOferta;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Precios [getId()=" + getId() + ", getItem()=" + getItem() + ", getPrecio()=" + getPrecio()
				+ ", getPrecioOferta()=" + getPrecioOferta() + ", getSaldo()=" + getSaldo() + "]";
	}

	
	
	
	
	
	

}
