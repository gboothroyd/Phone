package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Oct 6, 2021
 */
@Entity
@Table(name="service_providers")
public class ServiceProvider {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int yearEstablished;
	
	public ServiceProvider() {
		// TODO Auto-generated constructor stub
	}
	
	public ServiceProvider(int id, String name, int yearEstablished) {
		super();
		this.id = id;
		this.name = name;
		this.yearEstablished = yearEstablished;
	}
	
	public ServiceProvider(String name, int yearEstablished) {
		super();
		this.name = name;
		this.yearEstablished = yearEstablished;
	}

	public ServiceProvider(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the yearEstablished
	 */
	public int getYearEstablished() {
		return yearEstablished;
	}
	/**
	 * @param yearEstablished the yearEstablished to set
	 */
	public void setYearEstablished(int yearEstablished) {
		this.yearEstablished = yearEstablished;
	}

	@Override
	public String toString() {
		return "ServiceProvider [id=" + id + ", name=" + name + ", yearEstablished=" + yearEstablished + "]";
	}
}
