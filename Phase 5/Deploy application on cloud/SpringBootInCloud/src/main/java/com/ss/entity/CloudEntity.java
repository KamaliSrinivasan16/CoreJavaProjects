package com.ss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CloudEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String statement;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	@Override
	public String toString() {
		return "CloudEntity [id=" + id + ", statement=" + statement + "]";
	}
	public CloudEntity(long id, String statement) {
		super();
		this.id = id;
		this.statement = statement;
	}
	public CloudEntity() {
		super();
	}
	
	
	

}
