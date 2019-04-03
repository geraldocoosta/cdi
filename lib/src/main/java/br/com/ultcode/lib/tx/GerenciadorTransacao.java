package br.com.ultcode.lib.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.com.ultcode.lib.tx.annotation.Transacional;

@Transacional
@Interceptor
//@Priority(Interceptor.Priority.APPLICATION)
public class GerenciadorTransacao implements Serializable {

	/*
	 * A priority é definida aqui se não precisar ficar a controle de quem
	 * desenvolve. Como podemos ter outros interceptors que precisem rodar antes ou
	 * depois desse interceptor, melhor definir no beans.xml
	 */
	private static final long serialVersionUID = -2818857359297499689L;

	@Inject
	Transacionado transacionado;

	@AroundInvoke
	public Object gerenciaTransacao(InvocationContext context) {
		return transacionado.gerenciaTransacao(context);
	}

}
