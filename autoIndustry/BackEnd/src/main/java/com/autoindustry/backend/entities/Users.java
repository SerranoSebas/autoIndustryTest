package com.autoindustry.backend.entities;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "Users")
public class Users {

	//USUARIOS
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id; // ID DE USUARIO
	
	@Column(name = "name")
	private String name; // NOMBRE 	
	@Column(name = "lastname")
	private String lastname; // APELLIDO
	@Column(name = "position")
	private String position; // CARGO
	@Column(name = "age")
	private int age; // EDAD
	@Column(name = "created_date")
	private Date created_date; // FECHA DE INGRESO
	@Column(name = "updated_date")
	private Date updated_date; // FECHA DE MODIFICACION 
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(long id, String name, String lastname, String position, int age, Date created_date,
			Date updated_date) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.position = position;
		this.age = age;
		this.created_date = created_date;
		this.updated_date = updated_date;
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	
	
}
