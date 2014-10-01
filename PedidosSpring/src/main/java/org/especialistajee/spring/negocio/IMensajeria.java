package org.especialistajee.spring.negocio;

import org.especialistajee.spring.exception.PedidosException;

/**
 *
 * @author especialista
 */
public interface IMensajeria {

	void enviarAvisoPedido(int idProducto, int unidades) throws PedidosException;

}
