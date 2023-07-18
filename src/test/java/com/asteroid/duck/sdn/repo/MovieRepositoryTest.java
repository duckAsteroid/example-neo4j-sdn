package com.asteroid.duck.sdn.repo;

import com.asteroid.duck.sdn.model.MovieEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class MovieRepositoryTest extends AbstractIntegrationTest {
	@Autowired
	private Neo4jClient neo4jClient;

	@Autowired
	private MovieRepository repository;

	@Test
	public void simpleGet() {
		Optional<MovieEntity> theMatrixRevolutions = repository.findById("The Matrix Revolutions");
		assertTrue(theMatrixRevolutions.isPresent());
	}

}
