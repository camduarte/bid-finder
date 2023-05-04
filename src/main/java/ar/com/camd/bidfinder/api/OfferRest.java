/**
 * OfferRest.java
 * 
 * @copyright 2023, Christian Ariel Modesto Duarte. All rights reserved.
 */

package ar.com.camd.bidfinder.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.camd.bidfinder.dto.OfferDTO;
import ar.com.camd.bidfinder.model.Offer;
import ar.com.camd.bidfinder.model.Pedido;
import ar.com.camd.bidfinder.repository.PedidoRepository;

/**
 * <code>OfferRest</code>
 * Offers API.
 * 
 * @author   Christian Ariel Modesto Duarte <duarte.camd@gmail.com>
 * @version  1.0.0-SNAPSHOT
 */
@RestController
@RequestMapping("/offer")
public class OfferRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@PostMapping
	public Offer create(OfferDTO offerDTO) {
		Optional<Pedido> pedidoOpt = pedidoRepository.findById(offerDTO.getPedidoID());

		if (!pedidoOpt.isPresent()) {
			return null;
		}

		Pedido pedido = pedidoOpt.get();
		Offer offer = offerDTO.toOffer();
		offer.setPedido(pedido);
		pedido.getOffer().add(offer);
		pedidoRepository.save(pedido);

		return offer;
	}
}