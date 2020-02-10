package modal;

import java.sql.Date;

public class Persona {
	int id;
	String dni;
	String nombre;
	String apellidos;
	String user;
	String pass;
	Date fechaNacimiento;
	String puestoTrabajo;
	boolean trabajando;
	boolean sexo;
	
	public Persona() {
		super();
	}

	public Persona(int id, String dni, String nombre, String apellidos, String user, String pass, Date fechaNacimiento,
			String puestoTrabajo, boolean trabajando, boolean sexo) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.user = user;
		this.pass = pass;
		this.fechaNacimiento = fechaNacimiento;
		this.puestoTrabajo = puestoTrabajo;
		this.trabajando = trabajando;
		this.sexo = sexo;
	}

	public Persona(String dni, String nombre, String apellidos, String user, String pass, Date fechaNacimiento,
			String puestoTrabajo, boolean trabajando, boolean sexo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.user = user;
		this.pass = pass;
		this.fechaNacimiento = fechaNacimiento;
		this.puestoTrabajo = puestoTrabajo;
		this.trabajando = trabajando;
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPuestoTrabajo() {
		return puestoTrabajo;
	}

	public void setPuestoTrabajo(String puestoTrabajo) {
		this.puestoTrabajo = puestoTrabajo;
	}

	public boolean isTrabajando() {
		return trabajando;
	}

	public void setTrabajando(boolean trabajando) {
		this.trabajando = trabajando;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	
	

}
