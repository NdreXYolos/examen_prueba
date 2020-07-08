package com.redsocial.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pais {

	@Id
	@Column(name = "idpais")
	private int idPais;
	@Column
	private String nombre;
	
	 @OneToMany(mappedBy = "pais")
	 private List<Golosina> golosinas;
	
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	 
}
