package org.vlko.dota.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dota_hero")
public class Hero {

  @Id
  @GeneratedValue
  private long id;

  @Column(name = "name")
  private String name;

  public Hero() {
  }

  public Hero(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
