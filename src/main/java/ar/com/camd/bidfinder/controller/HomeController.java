package ar.com.camd.bidfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
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
		Sort sort = Sort.by("fechaEntrega").descending(); // Orden por fecha de más reciente a antiguo
		PageRequest pagination = PageRequest.of(0, 10, sort); // Paginación

		List<Pedido> pedidos = pedidoRepository.findByEstado(StatusPedido.ENTREGADO, pagination);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView onError() {
		return new ModelAndView("redirect:/home");
	}
}