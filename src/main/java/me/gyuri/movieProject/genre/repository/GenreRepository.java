package me.gyuri.movieProject.genre.repository;

import me.gyuri.movieProject.genre.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
