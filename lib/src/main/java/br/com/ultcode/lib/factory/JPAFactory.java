package br.com.ultcode.lib.factory;

import java.io.Serializable;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ultcode.lib.configurantion.annotation.Configuration;

@ApplicationScoped
public class JPAFactory implements Serializable {

	private static final long serialVersionUID = -8278011268106696200L;

	private EntityManagerFactory emf;

	@Inject
	@Configuration
	private Properties properties;

	@PostConstruct
	public void loadEmf() {
		emf = Persistence.createEntityManagerFactory(properties.getProperty("lib.persistenceUnit"));
	}

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}

	@PreDestroy
	public void preDestroy() {
		emf.close();
	}

}
