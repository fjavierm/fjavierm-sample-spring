package org.especialistajee.spring.negocio;

import org.especialistajee.spring.datos.IPedidosDAO;
import org.especialistajee.spring.exception.PedidosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorPedidosSimple implements IGestorPedidos {

	private static int cantidadMaxima = 50;

	@Autowired
	private IPedidosDAO pdao;

	@Autowired
	private IMensajeria m;

	public GestorPedidosSimple() {
	}

	@Override
	// @Transactional(rollbackFor = PedidosException.class)
	public void insertarPedido(int idCliente, int idProducto, int unidades) throws PedidosException {
		if (unidades > GestorPedidosSimple.cantidadMaxima) {
			throw new PedidosException("numero maximo permitido superado");
		} else {
			this.pdao.insertarPedido(idCliente, idProducto, unidades);
			this.m.enviarAvisoPedido(idProducto, unidades);
		}
	}

	@Override
	public void setCantidadMaxima(int max) {
		GestorPedidosSimple.cantidadMaxima = max;
	}

	@Override
	public int getCantidadMaxima() {
		return GestorPedidosSimple.cantidadMaxima;
	}
}
