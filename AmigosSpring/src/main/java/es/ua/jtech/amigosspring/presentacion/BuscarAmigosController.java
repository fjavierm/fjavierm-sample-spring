package es.ua.jtech.amigosspring.presentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ua.jtech.amigosspring.datos.IUsuariosDAO;
import es.ua.jtech.amigosspring.to.Usuario;

@Controller
@RequestMapping("/busqueda")
public class BuscarAmigosController {

	@Autowired
	IUsuariosDAO udao;

	@RequestMapping(method = RequestMethod.GET)
	public String preparaForm(Model modelo) {
		CriteriosBusqueda criterios = new CriteriosBusqueda();
		criterios.setEdadMin(18);
		criterios.setEdadMax(99);
		modelo.addAttribute("criterios", criterios);

		return "busqueda";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String procesaForm(@ModelAttribute("criterios") CriteriosBusqueda criterios, BindingResult result, Model modelo) {
		if (result.hasErrors()) {
			return "busqueda";
		}

		List<Usuario> users = this.udao.buscar(criterios.getLocalidad(), criterios.getEdadMin(), criterios.getEdadMax(),
				criterios.getSexo());

		modelo.addAttribute("encontrados", users);

		return "encontrados";
	}
}
