package ar.com.camd.bidfinder.dto;

import ar.com.camd.bidfinder.model.Pedido;

public class RequestNuevoPedido {
	private String nombreProducto;
	private String urlProducto;
	private String urlImagen;
	private String descripcion;

	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getUrlProducto() {
		return urlProducto;
	}
	public void setUrlProducto(String urlProducto) {
		this.urlProducto = urlProducto;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Pedido toPedido() {
		return new Pedido(nombreProducto, urlProducto, descripcion, urlImagen);
	}
}
