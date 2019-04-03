package br.com.alura.livraria.util;

import java.util.Map;

import javax.enterprise.event.Observes;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import br.com.alura.livraria.modelo.Usuario;
import br.com.ultcode.lib.jsf.annotation.ScopeMap;
import br.com.ultcode.lib.jsf.annotation.ScopeMap.Scope;
import br.com.ultcode.lib.jsf.phaselistener.annotation.After;
import br.com.ultcode.lib.jsf.phaselistener.annotation.Phase;
import br.com.ultcode.lib.jsf.phaselistener.annotation.Phase.Phases;

public class Autorizador {

	@Inject
	@ScopeMap(Scope.SESSION)
	private Map<String, Object> sessionMap;

	@Inject
	FacesContext context;

	@Inject
	NavigationHandler handler;

	public void afterPhase(@Observes @After @Phase(Phases.RESTORE_VIEW) PhaseEvent evento) {

		String nomePagina = context.getViewRoot().getViewId();

		System.out.println(nomePagina);

		if ("/login.xhtml".equals(nomePagina)) {
			return;
		}

		Usuario usuarioLogado = (Usuario) sessionMap.get("usuarioLogado");

		if (usuarioLogado != null) {
			return;
		}

		// redirecionamento para login.xhtml
		handler.handleNavigation(context, null, "/login?faces-redirect=true");
		context.renderResponse();
	}

}
