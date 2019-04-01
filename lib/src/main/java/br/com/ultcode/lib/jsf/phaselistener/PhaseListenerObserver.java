package br.com.ultcode.lib.jsf.phaselistener;

import java.lang.annotation.Annotation;

import javax.enterprise.event.Event;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import br.com.ultcode.lib.jsf.phaselistener.annotation.After;
import br.com.ultcode.lib.jsf.phaselistener.annotation.Before;
import br.com.ultcode.lib.jsf.phaselistener.annotation.PhaseLiteral;

public class PhaseListenerObserver {

	@Inject
	private BeanManager observer = CDI.current().getBeanManager();
	private Annotation momento;

	public PhaseListenerObserver after() {
		this.momento = new AnnotationLiteral<After>() {
		};
		return this;
	}

	public PhaseListenerObserver before() {
		this.momento = new AnnotationLiteral<Before>() {
		};
		return this;
	}

	public void fire(PhaseEvent event) {
		observer.fireEvent(event, momento, new PhaseLiteral(event.getPhaseId()));
	}
}
