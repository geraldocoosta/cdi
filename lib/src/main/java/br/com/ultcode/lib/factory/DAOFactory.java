package br.com.ultcode.lib.factory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ultcode.lib.dao.DAO;

@SuppressWarnings("unchecked")
public class DAOFactory implements Serializable {

	private static final long serialVersionUID = -8967987140017976532L;
	private EntityManager manager;

	public DAOFactory() {
	}

	@Inject
	public DAOFactory(EntityManager manager) {
		this.manager = manager;
	}

	@Produces
	public <T, I> DAO<T, I> factory(InjectionPoint point) {
		ParameterizedType type = (ParameterizedType) point.getType();
		Class<T> classe = (Class<T>) type.getActualTypeArguments()[0];
		return new DAO<T, I>(classe, manager);
	}
}
