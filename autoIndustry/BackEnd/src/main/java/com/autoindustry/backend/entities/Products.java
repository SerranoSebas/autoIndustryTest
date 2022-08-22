package com.autoindustry.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id; // ID DE PRODUCTO
	@Column(name = "name")
	private String name; // NOMBRE DE PRODUCTO
	
	
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Products(String name) {
		super();
		this.name = name;
	}


	public Products(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
