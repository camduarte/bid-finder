package ar.com.camd.bidfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.camd.bidfinder.dto.RequestNuevoPedido;
import ar.com.camd.bidfinder.model.Pedido;
import ar.com.camd.bidfinder.repository.PedidoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/formulario")
	public ModelAndView formulario() {
		return new ModelAndView("pedido/formulario");
	}
	
	@PostMapping("/nuevo")
	public ModelAndView nuevo(RequestNuevoPedido request) {
		Pedido pedido = request.toPedido();
		pedidoRepository.save(pedido);
		return new ModelAndView("pedido/formulario");
	}
}