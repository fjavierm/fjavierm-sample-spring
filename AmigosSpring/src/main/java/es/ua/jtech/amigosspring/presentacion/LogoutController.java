/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ua.jtech.amigosspring.presentacion;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author especialista
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    public String logout(HttpSession sesion) {
        sesion.invalidate();
        return "login";
    }
}
