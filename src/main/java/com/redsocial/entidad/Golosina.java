package com.redsocial.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "golosina")
public class Golosina {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "idgolosina")
	 private int idGolosina;
	
	 @Column(name = "nombre")
	 private String nombre;
	 
	 @Column(name = "precio")
	 private double precio;
	 
	 @Column(name = "stock")
	 private int stock;
	 
	 @Column(name = "categoria")
	 private String categoria;
	 
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyy-mm-dd")
	 @Column(name = "fechaVencimiento")
	 private Date fechaVencimiento;
	 
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyy-mm-dd")
	 @Column(name = "fechaRegistro")
	 private Date fechaRegistro;
	 
	 @ManyToOne(fetch = FetchType.LAZY )
	 @JoinColumn(name = "idpais")
	 private Pais pais;
	
	
	public int getIdGolosina() {
		return idGolosina;
	}
	public void setIdGolosina(int idGolosina) {
		this.idGolosina = idGolosina;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
}
