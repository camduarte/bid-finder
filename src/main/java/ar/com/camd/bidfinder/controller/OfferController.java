/**
 * OfertaController.java
 * 
 * @copyright 2023, Christian Ariel Modesto Duarte. All rights reserved.
 */

package ar.com.camd.bidfinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <code>OfertaController</code>
 * Serves request for ofertas.
 * 
 * @author   Christian Ariel Modesto Duarte <duarte.camd@gmail.com>
 * @version  1.0.0-SNAPSHOT
 */
@Controller
@RequestMapping("/offer")
public class OfferController {

	@GetMapping
	public ModelAndView getForm() {
		return new ModelAndView("/offer/home");
	} 

}
