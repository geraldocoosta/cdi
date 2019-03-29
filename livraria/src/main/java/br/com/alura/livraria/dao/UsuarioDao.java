package br.com.alura.livraria.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.alura.livraria.modelo.Usuario;

public class UsuarioDao {
	
	EntityManager manager;
	
	public UsuarioDao() {
	}

	@Inject
	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	public boolean existe(Usuario usuario) {
		
		TypedQuery<Usuario> query = manager.createQuery(
				  " select u from Usuario u "
				+ " where u.email = :pEmail and u.senha = :pSenha", Usuario.class);
		
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
		try {
			query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}
		
		
		return true;
	}

}
