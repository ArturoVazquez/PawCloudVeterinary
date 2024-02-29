package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {
   

	private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento; // Usamos LocalDate para manejar la fecha
    private String dni;
    private String nif;
    private String direccion;
    private String poblacion;
    private String provincia;
    private String telefonoFijo;
    private String telefonoMovil;
    private String email;

    // Constructor modificado para incluir el email y recibir LocalDate directamente
    public Cliente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String dni, String nif,
                   String direccion, String poblacion, String provincia, String telefonoFijo,
                   String telefonoMovil, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento; // Ya no necesitamos parsear, asumimos que se recibe directamente como LocalDate
        this.dni = dni;
        this.nif = nif;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
        this.email = email; // Ahora incluimos email en el constructor
    }
    
    private String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}}