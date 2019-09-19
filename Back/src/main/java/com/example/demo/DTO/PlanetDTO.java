package com.example.demo.DTO;

import com.example.demo.Entity.Star;

public class PlanetDTO {

	private int id;
	private String name;
	private float size;
	private StarDTO star;

	public PlanetDTO() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public StarDTO getStar() {
		return star;
	}

	public void setStar(StarDTO star) {
		this.star = star;
	}
	
}
