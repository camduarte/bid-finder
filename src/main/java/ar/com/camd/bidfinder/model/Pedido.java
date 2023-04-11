package ar.com.camd.bidfinder.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreProducto;
	private  BigDecimal valorNegociado;
	private LocalDate fechaEntrega;
	private String urlProducto;
	private String descripcion;
	private String urlImagen;

	@Enumerated(EnumType.STRING)
	private StatusPedido estado;

	public Pedido() {}

	public Pedido(String nombreProducto, String urlProducto, String descripcion, String urlImagen) {
		this.nombreProducto = nombreProducto;
		this.urlProducto = urlProducto;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getUrlProducto() {
		return urlProducto;
	}
	public void setUrlProducto(String urlProducto) {
		this.urlProducto = urlProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StatusPedido getEstado() {
		return estado;
	}
	public void setEstado(StatusPedido estado) {
		this.estado = estado;
	}
}