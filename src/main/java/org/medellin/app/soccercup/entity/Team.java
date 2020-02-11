package org.medellin.app.soccercup.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id;
	private final String name;

	public Team(String name) {
		this.name = name;
	}

	public Team(Long id, String name) {
		this.name = name;
		this.id = id;
	}

	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "id=" + this.id + ", name=" + this.name;
	}
}
