package com.autoindustry.backend.entities;

import java.sql.Date;

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
@Table(name="Inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id; // ID REGISTRO DE INVENTARIO
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_product")
	private Products product; // ID DE PRODUCTO
	
	@Column(name = "quantity")
	private int quantity; // CANTIDAD DE PRODUCTO
	@Column(name = "created_date")
	private Date created_date; // FECHA DE INGRESO
	@Column(name = "updated_date")
	private Date updated_date; // FECHA DE ACTUALIZACION
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="id_user")
	private Users user; // ID DE USUARIO
	
	
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(long id, Products product, int quantity, Date created_date, Date updated_date, Users user) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	
}
