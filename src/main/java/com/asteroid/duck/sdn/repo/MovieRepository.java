package com.asteroid.duck.sdn.repo;

import com.asteroid.duck.sdn.model.MovieEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<MovieEntity, String> {
}
