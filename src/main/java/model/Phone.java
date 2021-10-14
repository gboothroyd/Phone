package model;
import java.time.LocalDate;

import javax.persistence.Column;
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
@Table(name="phones")
public class Phone {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="RELEASE_DATE")
	private LocalDate releaseDate;
	@Column(name="COLOR")
	private String color;

	public Phone() {
		// TODO Auto-generated constructor stub
	}

	public Phone(String name, LocalDate releaseDate, String color) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.color = color;
	}

	/**
	 * @return the name
	 */
	
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the releaseDate
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	public String returnPhoneDetails() {
		return	this.name + ": " +	this.color + ", " + this.releaseDate;
	}
	
	

}
