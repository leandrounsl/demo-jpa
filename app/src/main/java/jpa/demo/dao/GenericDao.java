package jpa.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class GenericDao<T> {

	protected final EntityManager entityManager;

	protected void executeInsideTransaction(Consumer<EntityManager> action) {
		final EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			action.accept(entityManager);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

	public GenericDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	abstract Optional<T> get(long id);

	abstract List<T> getAll();

	abstract void save(T t);

	abstract void update(T t);

	abstract void delete(T t);
}
