package me.gyuri.movieProject.movieDirector.repository;

import me.gyuri.movieProject.movieDirector.entity.MovieDirector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDirectorRepository extends JpaRepository<MovieDirector, Long> {
}
