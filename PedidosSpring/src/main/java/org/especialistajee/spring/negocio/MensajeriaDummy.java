package org.especialistajee.spring.negocio;

import org.especialistajee.spring.exception.PedidosException;
import org.springframework.stereotype.Service;

/**
 *
 * @author especialista
 */
@Service
public class MensajeriaDummy implements IMensajeria {

	private static boolean ok = true;

	@Override
	public void enviarAvisoPedido(int idProducto, int unidades) throws PedidosException {
		if (MensajeriaDummy.ok) {
			System.out.println(new java.util.Date() + ": aviso de pedido enviado..." + unidades + " unidades del producto " + idProducto);
		} else {
			throw new PedidosException("No se puede enviar aviso");
		}
	}

	public static boolean isOk() {
		return MensajeriaDummy.ok;
	}

	public static void setOk(boolean ok) {
		MensajeriaDummy.ok = ok;
	}

}
