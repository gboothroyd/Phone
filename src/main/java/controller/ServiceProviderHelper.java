package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ServiceProvider;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Oct 11, 2021
 */
public class ServiceProviderHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Phone");
	
	public void insertServiceProvider(ServiceProvider sp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(sp);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ServiceProvider> showAllServiceProviders() {
		EntityManager em = emfactory.createEntityManager();
		List<ServiceProvider> allServiceProviders = em.createQuery("SELECT sp FROM ServiceProvider sp").getResultList();
		return allServiceProviders;
	}

	/**
	 * @param developerName
	 * @return
	 */
	public ServiceProvider findServiceProvider(String nameToLookUp) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ServiceProvider> typedQuery = em.createQuery("select prov from ServiceProvider prov where prov.name = :selectedName", ServiceProvider.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		ServiceProvider foundServiceProvider;
		try {
			foundServiceProvider = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundServiceProvider = new ServiceProvider(nameToLookUp);
		}
		em.close();
		
		return foundServiceProvider;
	}
}
