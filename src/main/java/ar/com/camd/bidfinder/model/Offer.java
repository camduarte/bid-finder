/**
 * Offer.java
 * 
 * @copyright 2023, Christian Ariel Modesto Duarte. All rights reserved.
 */

package ar.com.camd.bidfinder.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * <code>Offer</code>
 * Represents the offer.
 * 
 * @author   Christian Ariel Modesto Duarte <duarte.camd@gmail.com>
 * @version  1.0.0-SNAPSHOT
 */
@Entity
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal price;

	private LocalDate delivery;
	
	private String comment;

	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @param price The price.
	 * @param delivery The delivery date.
	 * @param comment The comment of the offer.
	 */
	public Offer(BigDecimal price, LocalDate delivery, String comment) {
		this.price = price;
		this.delivery = delivery;
		this.comment = comment;
	}
}