package me.gyuri.movieProject.actor.repository;

import me.gyuri.movieProject.actor.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
