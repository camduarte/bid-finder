package ar.com.camd.bidfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@GetMapping("/formulario")
	public ModelAndView formulario() {
		return new ModelAndView("/pedido/formulario");
	}
}