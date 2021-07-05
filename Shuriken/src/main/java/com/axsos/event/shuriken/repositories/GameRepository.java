package com.axsos.event.shuriken.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.event.shuriken.models.Game;

public interface GameRepository extends CrudRepository<Game, Long>{
	List<Game> findAll();
}
