/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ua.jtech.clienteDailymotion.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import es.ua.jtech.clienteDailymotion.modelo.ResultadosBusqueda;

/**
 *
 * @author especialista
 */

@Controller
public class VideosController {

	@RequestMapping("/buscar")
	public String buscar(@RequestParam("texto") String search, Model modelo) {
		RestTemplate template = new RestTemplate();
		String fields = "id,title,url,tags,thumbnail_medium_url";
		String uri = "https://api.dailymotion.com/videos?search=" + search + "&fields=" + fields;
		ResultadosBusqueda results = template.getForObject(uri, ResultadosBusqueda.class);

		modelo.addAttribute("resultados", results);

		return "resultados";
	}

}
