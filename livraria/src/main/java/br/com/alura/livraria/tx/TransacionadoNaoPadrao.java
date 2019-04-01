package br.com.alura.livraria.tx;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.ultcode.lib.tx.Transacionado;

@Alternative
@Priority(Interceptor.Priority.APPLICATION)
@Typed(Transacionado.class)
public class TransacionadoNaoPadrao implements Transacionado {

	private static final long serialVersionUID = 5554481286148016045L;

	@Inject
	EntityManager manager;

	@Override
	public Object gerenciaTransacao(InvocationContext context) {

		System.out.println("Antes de abrir a transação");
		manager.getTransaction().begin();
		try {
			Object proceed = context.proceed();
			System.out.println("Antes de fechar a transação");
			manager.getTransaction().commit();

			return proceed;
		} catch (Exception e) {
			System.out.println("Antes de dar rollback");
			manager.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

}
