package jpa.demo;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jpa.demo.dao.DepartmentDao;
import jpa.demo.model.Department;

class DepartmentDaoTest {
	
	private DepartmentDao dao;
	EntityManagerFactory emfactory = null;
	EntityManager entitymanager = null;

	@BeforeEach
	public void setUp() {
		emfactory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
		entitymanager = emfactory.createEntityManager();
		dao = new DepartmentDao(entitymanager);
	}
	
	@AfterEach
	public void end() {
		entitymanager.close();
		emfactory.close();
	}

	@Test
	void testAddDeparment() {
		Department department = new Department();
		department.setName("Development");
		dao.save(department);
		assertTrue(department.getDid() > 0);
	}

}

