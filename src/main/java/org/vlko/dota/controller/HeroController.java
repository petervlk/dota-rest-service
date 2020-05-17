package org.vlko.dota.controller;

import java.util.List;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.vlko.dota.persistence.entity.Hero;
import org.vlko.dota.persistence.repository.HeroRepository;

@RestController
public class HeroController {

  private final HeroRepository repository;
  private final HeroModelAssembler modelAssembler;

  public HeroController(HeroRepository repository,
                        HeroModelAssembler modelAssembler) {
    this.repository = repository;
    this.modelAssembler = modelAssembler;
  }

  @GetMapping("/simple")
  List<Hero> getAll() {
    return repository.findAll();
  }

  @GetMapping("/simple/{id}")
  Hero getOne(@PathVariable Long id) {
    return getHero(id);
  }

  @GetMapping("/")
  CollectionModel<EntityModel<Hero>> getAllLinked() {
    List<Hero> heroes = repository.findAll();
    return modelAssembler.toModel(heroes);
  }

  @GetMapping("/{id}")
  EntityModel<Hero> getOneLinked(@PathVariable Long id) {
    Hero hero = getHero(id);
    return modelAssembler.toModel(hero);
  }

  private Hero getHero(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new HeroNotFoundException(id));
  }
}
