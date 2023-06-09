package ar.com.camd.bidfinder.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.camd.bidfinder.dto.RequestNuevoPedido;
import ar.com.camd.bidfinder.model.Pedido;
import ar.com.camd.bidfinder.model.User;
import ar.com.camd.bidfinder.repository.PedidoRepository;
import ar.com.camd.bidfinder.repository.UserRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/formulario")
	public ModelAndView formulario(RequestNuevoPedido request) {
		return new ModelAndView("pedido/formulario");
	}

	@PostMapping("/nuevo")
	public ModelAndView nuevo(@Valid RequestNuevoPedido request, BindingResult result, Principal principal) {

		if (result.hasErrors()) {
			return new ModelAndView("pedido/formulario");
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findUserByUsername(username);
		Pedido pedido = request.toPedido();
		pedido.setUser(user);

		pedidoRepository.save(pedido);
		return new ModelAndView("redirect:/home");
	}
}