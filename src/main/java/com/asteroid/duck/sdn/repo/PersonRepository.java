package com.asteroid.duck.sdn.repo;

import com.asteroid.duck.sdn.model.PersonEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<PersonEntity, String> {
}
