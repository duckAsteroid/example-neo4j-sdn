package com.asteroid.duck.sdn;

import com.asteroid.duck.sdn.model.MovieEntity;
import com.asteroid.duck.sdn.repo.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
	private MovieRepository repository;

	@GetMapping("/all")
	public List<MovieEntity> list() {
		return repository.findAll();
	}

	@PostMapping("/new")
	public MovieEntity create(@RequestBody MovieEntity entity) {
		return repository.save(entity);
	}
	@GetMapping("/{title}")
	public MovieEntity get(@PathVariable String title) {
		return repository.findById(title).orElseThrow(NoSuchElementException::new);
	}

	@PostMapping("/{title}")
	public MovieEntity update(@PathVariable String title, @RequestBody MovieEntity entity) {
		if (entity.getTitle().equals(title)) {
			return repository.save(entity);
		}
		else throw new IllegalArgumentException("Wrong title");
	}

	@DeleteMapping("/{title}")
	public void delete(@PathVariable String title) {
		repository.deleteById(title);
	}


}
