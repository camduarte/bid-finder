package ar.com.camd.bidfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.camd.bidfinder.model.Pedido;
import ar.com.camd.bidfinder.repository.PedidosRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PedidosRepository repository;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		List<Pedido> pedidos = repository.findAll();
		
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
}