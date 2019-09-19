package com.example.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="api_planet")
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="planet_id")
	private int id;
	
	@Column(name="planet_name")
	private String name;
	
	@Column(name = "planet_size") 
	private float size;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "planet_fk_star")
	private Star star;
	
	public Planet() {
		
	}
	

	public Planet(int id, String name, float size) {
		this.id = id;
		this.name = name;
		this.size = size;
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


	public Star getStar() {
		return star;
	}


	public void setStar(Star star) {
		this.star = star;
	}
	
}
