package br.com.ultcode.lib.jsf.phaselistener.annotation;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.faces.event.PhaseId;
import javax.inject.Qualifier;

@Qualifier
@Retention(RUNTIME)
@Target({ PARAMETER })
public @interface Phase {

	Phases value();

	enum Phases {
		RESTORE_VIEW(PhaseId.RESTORE_VIEW),
		APPLY_REQUEST_VALUES(PhaseId.APPLY_REQUEST_VALUES),
		PROCESS_VALIDATIONS(PhaseId.PROCESS_VALIDATIONS),
		UPDATE_MODEL_VALUES(PhaseId.UPDATE_MODEL_VALUES),
		INVOKE_APPLICATION(PhaseId.INVOKE_APPLICATION),
		RENDER_RESPONSE(PhaseId.RENDER_RESPONSE);
	
	
		private PhaseId phaceId;

		Phases(PhaseId phaseId){
			this.phaceId = phaseId;
		}
		
		public PhaseId getPhaceId() {
			return phaceId;
		}
	
	}
}
