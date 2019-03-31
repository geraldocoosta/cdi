package br.com.ultcode.lib.tx;

import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Typed(Transacionado.class)
public class TransacionadoPadrao implements Transacionado {

	private static final long serialVersionUID = 559992356917231768L;

	@Inject
	EntityManager manager;

	public Object gerenciaTransacao(InvocationContext context) {
		manager.getTransaction().begin();
		try {
			Object proceed = context.proceed();
			manager.getTransaction().commit();
			return proceed;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
}
