package br.com.alura.livraria.tx;

import javax.enterprise.inject.Specializes;
import javax.interceptor.InvocationContext;

import br.com.ultcode.lib.tx.TransacionadoPadrao;

@Specializes
public class TransacionadoNaoPadrao extends TransacionadoPadrao {

	private static final long serialVersionUID = 5554481286148016045L;

	@Override
	public Object gerenciaTransacao(InvocationContext context) {

		System.out.println("Faz algo antes");
		Object gerenciaTransacao = super.gerenciaTransacao(context);
		System.out.println("Faz algo depois");
		return gerenciaTransacao;
	}
	
}
