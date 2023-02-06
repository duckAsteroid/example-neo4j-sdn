package com.asteroid.duck.sdn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Jacksonized
@Data
public class Attends {
	/**
	 * An injected ID from the spring data framework and Neo4J.
	 */
	@Id
	@GeneratedValue
	private Long id;
	private double likes;
	@TargetNode
	private Class theClass;
}
