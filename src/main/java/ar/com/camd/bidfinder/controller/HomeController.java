package ar.com.camd.bidfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.camd.bidfinder.model.Pedido;
import ar.com.camd.bidfinder.model.StatusPedido;
import ar.com.camd.bidfinder.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model) {

		List<Pedido> pedidos = pedidoRepository.findAll();
		
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
	
	@GetMapping("/{estado}")
	public ModelAndView porEstado(@PathVariable("estado") String estado) {
		List<Pedido> pedidos = pedidoRepository.findByEstado(StatusPedido.valueOf(estado.toUpperCase()));

		ModelAndView modelAndView = new ModelAndView("/home");
		modelAndView.addObject("pedidos", pedidos);

		return modelAndView;
	}
}