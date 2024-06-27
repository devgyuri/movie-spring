package me.gyuri.movieProject.movieBoxOffice.repository;

import me.gyuri.movieProject.movieBoxOffice.entity.MovieBoxOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieBoxOfficeRepository extends JpaRepository<MovieBoxOffice, Long> {
}
