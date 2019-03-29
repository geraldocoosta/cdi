package br.com.ultcode.lib.helpers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class MessageHelper implements Serializable {

	private static final long serialVersionUID = -8169767224068651648L;
	private FacesContext context;

	@Inject
	public MessageHelper(FacesContext context) {
		this.context = context;
	}

	public MessageHelper() {
	}

	public void addMessage(FacesMessage message) {
		addMessage(null, message);
	}

	public void addMessage(String clientId, FacesMessage message) {
		context.addMessage(clientId, message);
	}

	public MessageHelper onFlash() {
		context.getExternalContext().getFlash().setKeepMessages(true);
		return this;
	}
}
