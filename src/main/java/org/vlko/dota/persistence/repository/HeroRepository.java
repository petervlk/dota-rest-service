package org.vlko.dota.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vlko.dota.persistence.entity.Hero;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
