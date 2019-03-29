package br.com.ultcode.lib.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ultcode.lib.jpa.annotation.Query;

@SuppressWarnings("unchecked")
public class TypedQueryFactory {

	@Inject
	EntityManager manager;

	@Produces
	@Query("")
	public <X> TypedQuery<X> getTypedQuery(InjectionPoint point) {
		ParameterizedType parametirezedType = (ParameterizedType) point.getType();
		Class<X> classe = (Class<X>) parametirezedType.getActualTypeArguments()[0];

		String query = point.getAnnotated().getAnnotation(Query.class).value();
		return manager.createQuery(query, classe);
	}

}
