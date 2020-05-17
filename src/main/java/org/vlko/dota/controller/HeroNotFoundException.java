package org.vlko.dota.controller;

public class HeroNotFoundException extends RuntimeException{
  public HeroNotFoundException(Long id) {
    super("Could not find hero[id=" + id + "]");
  }
}
