package com.asteroid.duck.sdn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Builder
@Jacksonized
@Node
public class Class {
	/**
	 * An injected ID from the spring data framework and Neo4J.
	 */
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String code;
	private double level;
	private boolean open;
	private String full;
}
