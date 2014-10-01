package es.ua.jtech.amigosspring.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.ua.jtech.amigosspring.datos.IUsuariosDAO;
import es.ua.jtech.amigosspring.to.Usuario;

@Controller
@RequestMapping("/verAmigo")
public class VerAmigoController {

	@Autowired
	IUsuariosDAO udao;

	@RequestMapping(method = RequestMethod.GET)
	public String procesar(@RequestParam("amigo") String loginAmigo, Model modelo) {
		Usuario user = this.udao.getUsuario(loginAmigo);

		modelo.addAttribute("amigo", user);

		return "usuario";
	}
}
