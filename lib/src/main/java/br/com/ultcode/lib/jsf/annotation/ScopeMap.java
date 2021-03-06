package br.com.ultcode.lib.jsf.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RUNTIME)
@Target({ METHOD, PARAMETER, FIELD })
public @interface ScopeMap {

	ScopeMap.Scope value();

	enum Scope {
		REQUEST, SESSION, APPLICATION;
	}
}
