/**
 * UserController.java
 * 
 * @copyright 2023, Christian Ariel Modesto Duarte. All rights reserved.
 */

package ar.com.camd.bidfinder.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.camd.bidfinder.model.Pedido;
import ar.com.camd.bidfinder.model.StatusPedido;
import ar.com.camd.bidfinder.repository.PedidoRepository;

/**
 * <code>UserController</code>
 * Serves user requests
 * 
 * @author   Christian Ariel Modesto Duarte <duarte.camd@gmail.com>
 * @version  1.0.0-SNAPSHOT
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/order")
	public String home(Model model, Principal principal) {
		String username = principal.getName();
		List<Pedido> pedidos = this.pedidoRepository.findAllByUser(username);
		model.addAttribute("pedidos", pedidos);
		return "/pedido/user/home";
	}

	@GetMapping("/order/{status}")
	public String orderByStatus(Model model, @PathVariable("status") String status, Principal principal) {
		String username = principal.getName();

		List<Pedido> pedidos = this.pedidoRepository.findByEstadoAndUser(
				StatusPedido.valueOf(status.toUpperCase()),username
				);

		model.addAttribute("pedidos", pedidos);

		return "pedido/user/home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView onError() {
		return new ModelAndView("redirect:/user/order");
	}
}