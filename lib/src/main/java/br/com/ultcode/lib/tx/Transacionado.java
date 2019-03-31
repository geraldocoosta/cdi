package br.com.ultcode.lib.tx;

import java.io.Serializable;

import javax.interceptor.InvocationContext;

public interface Transacionado extends Serializable{
	 Object gerenciaTransacao(InvocationContext context) ;
}
