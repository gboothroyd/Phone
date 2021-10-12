package controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Phone;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Oct 11, 2021
 */
public class PhoneHelper {

	static	EntityManagerFactory emfactory	= Persistence.createEntityManagerFactory("Phone");
	public void insertItem(Phone p) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public	List<Phone>	showAllItems(){
		EntityManager em	=	emfactory.createEntityManager();
		List<Phone>	allItems = em.createQuery("SELECT i FROM Phone i").getResultList();
		return	allItems;
		}
	
	public	void	deleteItem(Phone toDelete)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Phone> typedQuery = em.createQuery("select p	from Phone p where	p.name = :selectedName and p.color = :selectedColor and p.releaseDate = :selectedReleaseDate",	Phone.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedColor",	toDelete.getColor());
		typedQuery.setParameter("selectedReleaseDate",	toDelete.getReleaseDate());
		typedQuery.setMaxResults(1);
		Phone result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public	void	updateItem(Phone toEdit)	{
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();
	}
	
	public	Phone searchForItemById(int	idToEdit)	{
	EntityManager em	= emfactory.createEntityManager();
	em.getTransaction().begin();
	Phone found	= em.find(Phone.class, idToEdit);
	em.close();
	return	found;
	}
	
	public	List<Phone>	searchForPhoneByName(String name)	{

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Phone> typedQuery	= em.createQuery("select p from Phone p where p.name = :selectedName", Phone.class);
		typedQuery.setParameter("selectedName", name);
		List<Phone> foundItems = typedQuery.getResultList();
		em.close();
		return	foundItems;
		}
	
	public	List<Phone>	searchForPhoneByColor(String color)	{
		EntityManager em =	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Phone> typedQuery	= em.createQuery("select p from Phone p where p.color = :selectedColor", Phone.class);
		typedQuery.setParameter("selectedColor", color);
		List<Phone> foundItems	= typedQuery.getResultList();
		em.close();
		return	foundItems;
		}
	
	public	List<Phone>	searchForPhoneByReleaseDate(LocalDate releaseDate)	{
		EntityManager em =	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Phone> typedQuery	= em.createQuery("select p from Phone p where p.releaseDate = :selectedReleaseDate", Phone.class);
		typedQuery.setParameter("selectedReleaseDate", releaseDate);
		List<Phone> foundItems	= typedQuery.getResultList();
		em.close();
		return	foundItems;
		}
	
	public	void	cleanUp(){
		emfactory.close();
		}

}
