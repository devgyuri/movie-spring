package me.gyuri.movieProject.movieActor.repository;

import me.gyuri.movieProject.movieActor.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieActorRepository extends JpaRepository<MovieActor, Long> {
}
