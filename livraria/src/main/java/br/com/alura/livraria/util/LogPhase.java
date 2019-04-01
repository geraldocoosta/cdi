package br.com.alura.livraria.util;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;

import br.com.ultcode.lib.jsf.phaselistener.annotation.After;
import br.com.ultcode.lib.jsf.phaselistener.annotation.Phase;
import br.com.ultcode.lib.jsf.phaselistener.annotation.Phase.Phases;

public class LogPhase {

	public void log(@Observes @After PhaseEvent phaseEvent) {
		System.out.println("Fase: " + phaseEvent.getPhaseId());
	}
}
