/**
 * PedidoRest.java
 * 
 * @copyright 2023, Christian Ariel Modesto Duarte. All rights reserved.
 */

package ar.com.camd.bidfinder.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.camd.bidfinder.model.Pedido;
import ar.com.camd.bidfinder.model.StatusPedido;
import ar.com.camd.bidfinder.repository.PedidoRepository;

/**
 * <code>PedidoRest</code>
 * API REST for orders.
 * 
 * @author   Christian Ariel Modesto Duarte <duarte.camd@gmail.com>
 * @version  1.0.0-SNAPSHOT
 */
@RestController
@RequestMapping("/api/order")
public class PedidoRest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/esperando")
	public List<Pedido> getPedidoEsperando() {

		Sort sort = Sort.by("id").descending();
		PageRequest pagination = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = this.pedidoRepository
				.findByEstado(StatusPedido.ESPERANDO, pagination);

		return pedidos;
	}
}
