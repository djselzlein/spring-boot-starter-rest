package com.selzlein.djeison.springbootstarterrest.app.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.selzlein.djeison.springbootstarterrest.app.domain.Model;
import com.selzlein.djeison.springbootstarterrest.app.service.ServiceDefault;

import lombok.Getter;

public abstract class ControllerDefault<T extends Model, S extends ServiceDefault<T, ?>> {

	@Autowired
	@Getter
	S service;

	@PostMapping("/")
	public T save(@RequestBody T entity) {
		return service.save(entity);
	}

	@PutMapping("/")
	public T update(@RequestBody T entity) {
		return service.update(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/")
	public Collection<T> get() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public T get(@PathVariable Long id) {
		return service.findOne(id);
	}

}
