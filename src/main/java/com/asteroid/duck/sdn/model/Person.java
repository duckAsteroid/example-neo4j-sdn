package com.asteroid.duck.sdn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.Set;

@Data
@Builder
@Jacksonized
@Node()
public class Person {
	/**
	 * An injected ID from the spring data framework and Neo4J.
	 */
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private double height;

	private String sex;

	@Relationship(value = "ATTENDS", direction = Relationship.Direction.OUTGOING)
	private Set<Attends> classesAttended;
}
