package com.ty.onetoone_uni.person.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.onetoone_uni.person.dto.Aadharcard;
import com.ty.onetoone_uni.person.dto.Person;



public class PersonDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Aadharcard aadharcard = person.getAadharcard();
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(aadharcard);
		;
		entityTransaction.commit();
	}

	public void updatePerson(int id, String name) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		person.setName(name);
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		if (person != null)
			entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
	}

	public Person getPersonById(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		return person;
	}

	public java.util.List<Person> getAllPerson() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from person p");
		java.util.List<Person> list = query.getResultList();
		return list;
	}

}
