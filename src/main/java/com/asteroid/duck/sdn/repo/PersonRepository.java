package com.asteroid.duck.sdn.repo;

import com.asteroid.duck.sdn.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}