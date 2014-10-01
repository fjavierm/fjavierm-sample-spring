package org.especialistajee.spring.datos;

import java.util.List;

import javax.sql.DataSource;

import org.especialistajee.spring.modelo.Pedido;

public interface IPedidosDAO {

	int insertarPedido(int idCliente, int idProducto, int unidades);

	void setDataSource(DataSource ds);

	List<Pedido> listarPedidos();
}
