package br.com.sDuc.util;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class GenericDAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public T inserir(T entity) {
		manager.persist(manager.contains(entity) ? entity : manager.merge(entity));
		return entity;
	}

	@Transactional
	public T salvar(T entity) {
		manager.merge(entity);
		return entity;
	}

	@Transactional
	public void excluir(T entity) {
		manager.remove(entity);
	}
	
	@Transactional
	public T find(Class<T> clazz, Object primaryKey){
		return manager.find(clazz, primaryKey);
	}
	
	@Transactional
	public List<T> query(Class<T> clazz, String consulta){
		return manager.createQuery(consulta, clazz).getResultList();
	}
	
	@Transactional
	public T querySingle(Class<T> clazz, String consulta){
		return manager.createQuery(consulta, clazz).getSingleResult();
	}
	
	public EntityManager getEntityManager(){
		return this.manager;
	}
}
