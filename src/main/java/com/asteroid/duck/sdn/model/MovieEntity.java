package com.asteroid.duck.sdn.model;

import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node("Movie")
public class MovieEntity {

	@Id
	private final String title;

	@Property("tagline")
	private final String description;

	@Version
	private Long version;

	@Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
	private List<Roles> actorsAndRoles;

	@Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
	private List<PersonEntity> directors = new ArrayList<>();


	public MovieEntity(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}


	public List<PersonEntity> getDirectors() {
		return directors;
	}

	public List<Roles> getActorsAndRoles() {
		return actorsAndRoles;
	}
}
