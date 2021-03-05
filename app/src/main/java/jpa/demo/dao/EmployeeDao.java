package jpa.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa.demo.model.Employee;

public class EmployeeDao extends GenericDao<Employee> {

	public EmployeeDao(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Optional<Employee> get(long id) {
		return Optional.ofNullable(entityManager.find(Employee.class, id));
	}

	@Override
	public List<Employee> getAll() {
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		return query.getResultList();
	}

	@Override
	public void save(Employee t) {
		 executeInsideTransaction(entityManager -> entityManager.persist(t));

	}

	@Override
	public void update(Employee t) {
		executeInsideTransaction(entityManager -> entityManager.merge(t));

	}

	@Override
	public void delete(Employee t) {
		executeInsideTransaction(entityManager -> entityManager.remove(t));
	}

}
