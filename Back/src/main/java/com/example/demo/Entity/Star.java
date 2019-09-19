package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="api_star")
public class Star {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="star_id")
	private int id;
	
	@Column(name="star_name")
	private String nombre;

	@Column(name="star_densidad")
	private float densidad;

	@OneToMany(mappedBy ="star") 
	private List<Planet> planetas = new ArrayList();
	
	public Star() {
	}

	public Star(int id, String nombre, float densidad) {
		this.id = id;
		this.nombre = nombre;
		this.densidad = densidad;
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

	public float getDensidad() {
		return densidad;
	}

	public void setDensidad(float densidad) {
		this.densidad = densidad;
	}

	public List<Planet> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<Planet> planetas) {
		this.planetas = planetas;
	}
	
	
}
