package me.gyuri.movieProject.movie.repository;

import me.gyuri.movieProject.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
