package org.especialistajee.spring.negocio;

import org.especialistajee.spring.exception.PedidosException;

public interface IGestorPedidos {

	void insertarPedido(int idCliente, int idProducto, int unidades) throws PedidosException;

	void setCantidadMaxima(int max);

	int getCantidadMaxima();
}
