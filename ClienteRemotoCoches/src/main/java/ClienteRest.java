import org.especialistajee.Coche;
import org.springframework.web.client.RestTemplate;

public class ClienteRest {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		String uri = "http://localhost:8080/AlquilerCoches/coches/{matricula}.do";
		Coche coche = template.getForObject(uri, Coche.class, "1111JKG");
		System.out.println(coche.getMatricula() + ", " + coche.getModelo());

	}

}
