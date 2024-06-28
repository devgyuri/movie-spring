package me.gyuri.movieProject.boxOffice.repository;

import me.gyuri.movieProject.boxOffice.entity.BoxOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxOfficeRepository extends JpaRepository<BoxOffice, Long> {
}
