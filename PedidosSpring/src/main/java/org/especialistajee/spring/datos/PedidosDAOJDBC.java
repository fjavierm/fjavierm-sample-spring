package org.especialistajee.spring.datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.especialistajee.spring.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class PedidosDAOJDBC implements IPedidosDAO {

	private DataSource ds;
	private SimpleJdbcTemplate template;

	@Override
	public int insertarPedido(int idCliente, int idProducto, int unidades) {
		int stock = 0;
		Statement sql = null;
		ResultSet rs = null;
		Connection con = null;
		int idPedido = 0;

		try {
			con = DataSourceUtils.getConnection(this.ds);
			// crear registro en la tabla de pedidos
			sql = con.createStatement();
			sql.execute("insert into pedidos values(NULL," + idProducto + "," + idCliente + "," + unidades + ")");
			// obtener el id del pedido (esto solo vale en mysql)
			sql = con.createStatement();
			rs = sql.executeQuery("select last_insert_id()");
			if (rs.next()) {
				idPedido = rs.getInt(1);
			}
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				return idPedido;
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
		}
	}

	@Override
	@Autowired
	public void setDataSource(DataSource ds) {
		this.template = new SimpleJdbcTemplate(ds);
		// this.ds = ds;
	}

	private static final String SELECT_PEDIDOS = "select * from pedidos order by id";

	@Override
	public List<Pedido> listarPedidos() {
		PedidosTOMapper pedidoTo = new PedidosTOMapper();

		return this.template.query(PedidosDAOJDBC.SELECT_PEDIDOS, pedidoTo);
	}
}
