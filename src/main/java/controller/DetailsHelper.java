package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Details;


/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Oct 11, 2021
 */
public class DetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Phone");
	
	
	public void insertNewListDetails(Details d) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(d);
	em.getTransaction().commit();
	em.close();
	}
	
	public List<Details> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<Details> allDetails = em.createQuery("SELECT d FROM Details d").getResultList();
		return allDetails;
		}
	
	public Details searchForListDetailsById(Integer tempId) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	Details found = em.find(Details.class, tempId);
	em.close();
	return found;
	}

	/**
	 * @param tempId
	 * @return
	 */
	public Details searchForListById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Details found = em.find(Details.class, tempId);
		em.close();
		return found;
	}

	/**
	 * @param listToDelete
	 */
	public void deleteList(Details toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Details> typedQuery = em.createQuery("select detail from Details detail where detail.id = :selectedId", Details.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		Details result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param listToUpdate
	 */
	public void updateList(Details toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
}
