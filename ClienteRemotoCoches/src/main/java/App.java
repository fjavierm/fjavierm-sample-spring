import java.util.List;

import org.especialistajee.Coche;
import org.especialistajee.spring.datos.ICocheDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("cliente.xml");
		ICocheDAO dao = (ICocheDAO) contexto.getBean("httpProxy");

		List<Coche> coches = dao.listar();

		for (Coche c : coches) {
			System.out.println(c.getMatricula());
		}
	}
}
