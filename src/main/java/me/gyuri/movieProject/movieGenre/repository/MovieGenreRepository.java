package me.gyuri.movieProject.movieGenre.repository;

import me.gyuri.movieProject.movieGenre.entity.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieGenreRepository extends JpaRepository<MovieGenre, Long> {
}
