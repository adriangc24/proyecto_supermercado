package modal;

import java.sql.Date;

public class Producto {
	int id;
	String nombre;
	String descripcion;
	float precioSinIva;
	int cantidad;
	String categoria;
	String marca;
	Date fechaVencimiento;
	
	public Producto(int id, String nombre, String descripcion, float precioSinIva, int cantidad, String categoria,
			String marca, Date fechaVencimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioSinIva = precioSinIva;
		this.cantidad = cantidad;
		this.categoria = categoria;
		this.marca = marca;
		this.fechaVencimiento = fechaVencimiento;
	}
	public Producto(int id, String nombre, String descripcion, float precioSinIva, int cantidad, String categoria,
			String marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioSinIva = precioSinIva;
		this.cantidad = cantidad;
		this.categoria = categoria;
		this.marca = marca;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecioSinIva() {
		return precioSinIva;
	}
	public void setPrecioSinIva(float precioSinIva) {
		this.precioSinIva = precioSinIva;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
	
}
