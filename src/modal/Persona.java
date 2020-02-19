package modal;

import java.awt.Checkbox;
import java.sql.Date;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;

public class Persona {
	int id;
	String dni;
	String nombre;
	String apellidos;
	String user;
	String pass;
	Date fechaNacimiento;
	String puestoTrabajo;
	CheckBox trabajando = new CheckBox();
	String sexo;

	public Persona() {
		super();
	}

	public Persona(int id, String dni, String nombre, String apellidos, String user, String pass,
			Date fechaNacimiento, String puestoTrabajo, CheckBox trabajando) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.user = user;
		this.pass = pass;
		this.fechaNacimiento = fechaNacimiento;
		this.puestoTrabajo = puestoTrabajo;
		trabajando.setAlignment(Pos.CENTER);
		this.trabajando = trabajando;
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

	public CheckBox isTrabajando() {
		CheckBox c = trabajando;
		c.setAlignment(Pos.CENTER);
		try {
		System.out.println(c.isSelected());
		return c;
		}
		catch(Exception e) {
			System.out.println("error");
			return c;
		}

	}

	public void setTrabajando(boolean trabajando) {
		this.trabajando.setSelected(trabajando);
	}

	public static CheckBox setEstado(boolean estado) {
		CheckBox c = new CheckBox();
		if (estado)
			c.setSelected(true);
		else
			c.setSelected(false);

		return c;
	}

	public String isSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
