/**
 * OfferDTO.java
 * 
 * @copyright 2023, Christian Ariel Modesto Duarte. All rights reserved.
 */

package ar.com.camd.bidfinder.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.com.camd.bidfinder.model.Offer;

/**
 * <code>OfferDTO</code>
 * Model for offer form.
 * 
 * @author   Christian Ariel Modesto Duarte <duarte.camd@gmail.com>
 * @version  1.0.0-SNAPSHOT
 */
public class OfferDTO {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Long pedidoID;
	private String price;
	private String delivery;
	private String comment;

	/**
	 * @return the pedidoID
	 */
	public Long getPedidoID() {
		return pedidoID;
	}

	/**
	 * Creates an offer from DTO.
	 * @return The offer.
	 */
	public Offer toOffer() {
		LocalDate delivery = LocalDate.parse(this.delivery, formatter);
		BigDecimal price = new BigDecimal(this.price);
		return new Offer(price, delivery, this.comment);
	}
}