package br.com.desafioNeomind.core;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

@Transactional
@Interceptor
public class Managed implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("desafioNeomind");
	private final ThreadLocal<EntityManager> entityManager = new ThreadLocal<>();

	public Managed() {
		if (this.entityManager.get() == null) {
			this.entityManager.set(entityManagerFactory.createEntityManager());
		}
	}

	public EntityManager getEntityManager() {
		return this.entityManager.get();
	}

	@AroundInvoke
	public Object runTransaction(InvocationContext context) throws Exception {

		getEntityManager().getTransaction().begin();

		Object result = context.proceed();
		getEntityManager().getTransaction().commit();

		return result;
	}
}
