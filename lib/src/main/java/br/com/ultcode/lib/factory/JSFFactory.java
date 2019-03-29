package br.com.ultcode.lib.factory;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import br.com.ultcode.lib.jsf.annotation.ScopeMap;
import br.com.ultcode.lib.jsf.annotation.ScopeMap.Scope;

public class JSFFactory implements Serializable {

	private static final long serialVersionUID = 2373287715544493073L;

	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	@Produces
	public Flash getFlash() {
		return getExternalContext().getFlash();
	}

	@Produces
	@ScopeMap(Scope.SESSION)
	public Map<String, Object> getSessionMap() {
		return getExternalContext().getSessionMap();
	}

	@Produces
	@ScopeMap(Scope.REQUEST)
	public Map<String, Object> getRequestMap() {
		return getExternalContext().getRequestMap();
	}

	@Produces
	@ScopeMap(Scope.APPLICATION)
	public Map<String, Object> getApplicationMap() {
		return getExternalContext().getApplicationMap();
	}

	private ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}
}
