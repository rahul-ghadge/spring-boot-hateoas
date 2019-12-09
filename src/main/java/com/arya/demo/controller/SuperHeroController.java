package com.arya.demo.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.arya.demo.exception.AgeNotInRangeException;
import com.arya.demo.exception.SuperHeroNotFoundException;
import com.arya.demo.model.SuperHero;
import com.arya.demo.util.SuperHeroUtils;

@SuppressWarnings("deprecation")
@RestController
public class SuperHeroController {
	
	@Autowired
	private SuperHeroUtils superHeroUtils;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
    
    
	@GetMapping("/super-heros")
	public List<SuperHero> getHeroSuperHeros() {    	
		List<SuperHero> superHeros =  superHeroUtils.getSuperHeros();
		
		superHeros.stream().map(s -> {
			return s.add(ControllerLinkBuilder
                .linkTo(this.getClass())
                .slash("/super-heros/name")
                .slash(s.getName())
                .withSelfRel());
		}).collect(Collectors.toList());
		
		
		return superHeros;
	}
    
    
	@GetMapping("/super-heros/name/{name}")
	public SuperHero getHeroByName(@PathVariable String name) {
    	
    	SuperHero superHero = superHeroUtils.getSuperHeros().stream()
				.filter(hero -> hero.getName().equals(name)).findFirst()
				.orElseThrow(() -> new SuperHeroNotFoundException(name + " not found"));
    	
    	superHero.add(ControllerLinkBuilder
                .linkTo(this.getClass())
                .slash("/super-heros/age")
                .slash(superHero.getAge())
                .withSelfRel());
    	
    	
    	Link link = ControllerLinkBuilder
        .linkTo(ControllerLinkBuilder.methodOn(this.getClass())
        .getHeroSuperHeros()).withRel("/super-heros");
    	
    	superHero.add(link);               
    	
    	return superHero;
	}
    
    
    
	@GetMapping("/super-heros/age/{age}")
	public ResponseEntity<SuperHero> getHeroByAge(@PathVariable int age) {
		
		if(20 >= age)
			throw new AgeNotInRangeException("We don't recruit teen as Super Hero");
    	
		SuperHero superHero = superHeroUtils.getSuperHeros().stream()
				.filter(hero -> hero.getAge() == age).findFirst().get();
		
		superHero.add(ControllerLinkBuilder
                .linkTo(this.getClass())
                .slash("/super-heros/name")
                .slash(superHero.getName())
                .withSelfRel());
		
		Link link = ControllerLinkBuilder
		        .linkTo(ControllerLinkBuilder.methodOn(this.getClass())
		        .getHeroSuperHeros()).withRel("/super-heros");
		    	
		superHero.add(link);
        
        return new ResponseEntity<SuperHero>(superHero, HttpStatus.OK);
	}

}
