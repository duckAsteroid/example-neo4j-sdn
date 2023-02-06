package com.asteroid.duck.sdn.repo;

import com.asteroid.duck.sdn.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends Neo4jRepository<Person, Long> {
}
