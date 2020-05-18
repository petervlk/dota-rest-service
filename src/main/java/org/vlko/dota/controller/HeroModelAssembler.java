package org.vlko.dota.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;
import org.vlko.dota.persistence.entity.Hero;

@Component
public class HeroModelAssembler {

  public EntityModel<Hero> toModel(Hero hero) {
    return EntityModel.of(hero,
        linkTo(methodOn(HeroController.class).getOneLinked(hero.getId())).withSelfRel(),
        linkTo(methodOn(HeroController.class).getAllLinked()).withRel("heroList")
    );
  }

  public CollectionModel<EntityModel<Hero>> toModel(List<Hero> heroList) {
    return CollectionModel.of(
        heroList.stream()
            .map(this::toModel)
            .collect(Collectors.toList()),
        linkTo(methodOn(HeroController.class).getAllLinked()).withRel("heroList")
    );
  }
}
