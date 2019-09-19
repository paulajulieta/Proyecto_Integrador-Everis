package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.Planet;

public class StarDTO {
	
	private int id;
	private String nombre;
	private float densidad;
	private List<Planet> planetas = new ArrayList();
	
	public StarDTO() {
	}
	
	public StarDTO(int id, String nombre, float densidad) {
		this.id = id;
		this.nombre = nombre;
		this.densidad = densidad;
	}
	
	public StarDTO(int id, String nombre, float densidad, List<Planet> planetas) {
		this.id = id;
		this.nombre = nombre;
		this.densidad = densidad;
		this.planetas = planetas;
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
