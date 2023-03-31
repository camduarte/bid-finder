package ar.com.camd.bidfinder.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.camd.bidfinder.model.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNombreProducto("Nintendo Switch OLED 64GB Splatoon 3 Edition color degradado azul y degradado amarillo y negro");
		pedido.setValorNegociado(BigDecimal.valueOf(239.000));
		pedido.setFechaEntrega(LocalDate.now());
		pedido.setUrlProducto("https://www.mercadolibre.com.ar/nintendo-switch-oled-64gb-splatoon-3-edition-color-degradado-azul-y-degradado-amarillo-y-negro/p/MLA19610178?pdp_filters=category:MLA438566#searchVariation=MLA19610178&position=6&search_layout=stack&type=product&tracking_id=ba83a0e2-366a-408f-81ac-085c223a00c3");
		pedido.setUrlImagen("https://http2.mlstatic.com/D_NQ_NP_995408-MLA51572691067_092022-O.webp");
		pedido.setDescripcion("Con tu consola Switch tendrás entretenimiento asegurado todos los días. Su tecnología fue creada para poner nuevos retos tanto a jugadores principiantes como expertos.");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
}