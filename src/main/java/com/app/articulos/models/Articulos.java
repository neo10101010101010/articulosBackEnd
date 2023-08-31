package com.app.articulos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name = "articulos")
public class Articulos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	@Size(max = 30)
	private String nombre;
	@Column(name = "medida")
	private String medida;
	@Column(name = "clave")
	@Size(min = 3, max = 30)
	private String clave;
	@Column(name = "precio")
	private double precio;
	
	
	public Articulos(Long id, String nombre, String medida, String clave, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.medida = medida;
		this.clave = clave;
		this.precio = precio;
	}

	
	public Articulos()
	{
		
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getMedida() {
		return medida;
	}


	public void setMedida(String medida) {
		this.medida = medida;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
