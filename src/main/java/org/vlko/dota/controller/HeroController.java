package org.vlko.dota.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.vlko.dota.persistence.entity.Hero;
import org.vlko.dota.persistence.repository.HeroRepository;

@RestController
public class HeroController {

  private final HeroRepository repository;

  public HeroController(HeroRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/heroes")
  List<Hero> getAll() {
    return repository.findAll();
  }

  @GetMapping("/hero/{id}")
  Hero getOne(@PathVariable Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new HeroNotFoundException(id));
  }
}
