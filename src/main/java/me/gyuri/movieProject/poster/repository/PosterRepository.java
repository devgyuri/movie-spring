package me.gyuri.movieProject.poster.repository;

import me.gyuri.movieProject.poster.entity.Poster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosterRepository extends JpaRepository<Poster, Long> {
}
