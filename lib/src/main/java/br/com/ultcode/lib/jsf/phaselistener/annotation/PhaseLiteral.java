package br.com.ultcode.lib.jsf.phaselistener.annotation;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseId;

public class PhaseLiteral extends AnnotationLiteral<Phase> implements Phase {

	private static final long serialVersionUID = -8273920534677186237L;
	private Phases phases;

	public PhaseLiteral(PhaseId phaseId) {
		phases = Phase.Phases.valueOf(phaseId.getName());
	}

	@Override
	public Phases value() {
		return phases;
	}

}
