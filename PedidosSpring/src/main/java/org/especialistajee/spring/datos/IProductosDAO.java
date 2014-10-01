package org.especialistajee.spring.datos;

import org.especialistajee.spring.modelo.ProductoEntity;

public interface IProductosDAO {

	ProductoEntity buscarProducto(int id);
}
