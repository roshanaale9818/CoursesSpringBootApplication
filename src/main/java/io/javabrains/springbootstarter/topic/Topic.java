package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//we have to make a table name of Topic which can be done as adding entity annotation
@Entity
@Table(name ="Topic")
public class Topic {
	@Id // it specifies the corresponding field as primary key
	private String id;
	private String name;
	private String description;
	public Topic() {
		//for easier intilization of constructor
	}
	
	//constructor
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	//getter setter methods
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
