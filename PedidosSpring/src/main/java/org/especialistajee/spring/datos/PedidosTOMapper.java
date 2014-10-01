package org.especialistajee.spring.datos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.especialistajee.spring.modelo.Pedido;
import org.springframework.jdbc.core.RowMapper;

public class PedidosTOMapper implements RowMapper<Pedido> {

	@Override
	public Pedido mapRow(ResultSet rs, int numRow) throws SQLException {
		Pedido pedido = new Pedido();
		pedido.setId(rs.getInt("id"));
		pedido.setIdCliente(rs.getInt("idCliente"));
		pedido.setIdProducto(rs.getInt("idProducto"));
		pedido.setUnidades(rs.getInt("unidades"));

		return pedido;
	}
}
