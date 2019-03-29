package br.com.ultcode.lib.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> implements Serializable{
	
	private static final long serialVersionUID = -1603139969274284275L;
	private final Class<T> classe;
	private EntityManager em;

	public DAO(Class<T> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;
	}

	public void adiciona(T t) {
		em.getTransaction().begin();

		// persiste o objeto
		em.persist(t);

		// commita a transacao
		em.getTransaction().commit();
	}

	public void remove(T t) {
		em.getTransaction().begin();

		em.remove(em.merge(t));

		em.getTransaction().commit();
	}

	public void atualiza(T t) {
		em.getTransaction().begin();

		em.merge(t);

		em.getTransaction().commit();
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorId(Integer id) {
		 
		T instancia = em.find(classe, id);
		return instancia;
	}

	public int contaTodos() {
		 
		long result = (Long) em.createQuery("select count(n) from " + classe.getSimpleName() +" n")
				.getSingleResult();

		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		 
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return lista;
	}

}