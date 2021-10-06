package edu.supavenir.ormtest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
abstract public class AbstractRestController<T> {
	
	@Autowired
	private JpaRepository<T, Integer> Repo;
	
	@GetMapping()
	public List<T> indexAction() {
		return Repo.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<T> getOneAction(@PathVariable int id) {
		return Repo.findById(id);
	}
	
	@PostMapping()
	public T addAction(@RequestBody T model) {
		Repo.saveAndFlush(model);
		return model;
	}
	
	@PutMapping("{id}")
	public T updateAction(@PathVariable int id, @RequestBody T model) {
		
		if(Repo.existsById(id)) {
			
			Repo.save(model);
			return model;
			
		}
		
		return null;
	}
	
	@DeleteMapping("{id}")
	public T deleteAction(@PathVariable int id) {
		
		Optional<T> opt = Repo.findById(id);
		
		if(opt.isPresent()) {
			
			T model = opt.get();
			Repo.delete(model);
			return model;
			
		}
		
		return null;
	}
}
