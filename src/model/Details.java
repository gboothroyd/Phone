package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Oct 6, 2021
 */

@Entity
public class Details {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private ServiceProvider provider;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Phone> listOfPhones;

	public Details() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param listName
	 * @param provider
	 * @param listOfPhones
	 */
	public Details(int id, String listName, ServiceProvider provider, List<Phone> listOfPhones) {
		super();
		this.id = id;
		this.listName = listName;
		this.provider = provider;
		this.listOfPhones = listOfPhones;
	}

	/**
	 * @param listName
	 * @param provider
	 * @param listOfPhones
	 */
	public Details(String listName, ServiceProvider provider, List<Phone> listOfPhones) {
		super();
		this.listName = listName;
		this.provider = provider;
		this.listOfPhones = listOfPhones;
	}

	/**
	 * @param listName
	 * @param provider
	 */
	public Details(String listName, ServiceProvider provider) {
		super();
		this.listName = listName;
		this.provider = provider;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * @return the provider
	 */
	public ServiceProvider getProvider() {
		return provider;
	}

	/**
	 * @param provider the provider to set
	 */
	public void setProvider(ServiceProvider provider) {
		this.provider = provider;
	}

	/**
	 * @return the listOfPhones
	 */
	public List<Phone> getListOfPhones() {
		return listOfPhones;
	}

	/**
	 * @param listOfPhones the listOfPhones to set
	 */
	public void setListOfPhones(List<Phone> listOfPhones) {
		this.listOfPhones = listOfPhones;
	}

	@Override
	public String toString() {
		return "Details [id=" + id + ", listName=" + listName + ", provider=" + provider + ", listOfPhones="
				+ listOfPhones + "]";
	}
	
	

}
