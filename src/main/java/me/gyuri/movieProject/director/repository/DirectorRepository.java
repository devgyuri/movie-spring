package me.gyuri.movieProject.director.repository;

import me.gyuri.movieProject.director.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
