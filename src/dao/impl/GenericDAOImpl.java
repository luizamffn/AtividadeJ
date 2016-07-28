package dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ifpi.dao.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {
	private EntityManager em;
	private Class<T> persistenceClass;
	
	public GenericDAOImpl(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}
	
	@Override
	public T save(T objeto) {
		em.getTransaction().begin();
		T mergedObj = em.merge(objeto);
		em.getTransaction().commit();
		
		return mergedObj;
	}

	@Override
	public void delete(T objeto) {
		em.getTransaction().begin();
		em.remove(em.merge(objeto));
		em.getTransaction().commit();
	}

	@Override
	public T findByID(Serializable id) {
		T obj = (T)em.find(persistenceClass, id);
		return obj;
	}

	@Override
	public List<T> findAll() {
		TypedQuery<T> query = em.createQuery("select c from " + this.persistenceClass.getSimpleName()+" c", this.persistenceClass);
		return query.getResultList();
	}

}
