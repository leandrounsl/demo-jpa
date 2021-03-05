package jpa.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa.demo.model.Department;

public class DepartmentDao extends GenericDao<Department> {

	public DepartmentDao(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Optional<Department> get(long id) {
		return Optional.ofNullable(entityManager.find(Department.class, id));
	}

	@Override
	public List<Department> getAll() {
		Query query = entityManager.createQuery("SELECT d FROM Department d");
		return query.getResultList();
	}

	@Override
	public void save(Department t) {
		executeInsideTransaction(entityManager -> entityManager.persist(t));

	}

	@Override
	public void update(Department t) {
		executeInsideTransaction(entityManager -> entityManager.merge(t));

	}

	@Override
	public void delete(Department t) {
		executeInsideTransaction(entityManager -> entityManager.remove(t));
	}
}
