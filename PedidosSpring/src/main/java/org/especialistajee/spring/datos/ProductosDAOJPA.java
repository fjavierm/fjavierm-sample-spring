package org.especialistajee.spring.datos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.especialistajee.spring.modelo.ProductoEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ProductosDAOJPA implements IProductosDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public ProductoEntity buscarProducto(int id) {
		return this.em.find(ProductoEntity.class, id);
	}

}
