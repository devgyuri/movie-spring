package me.gyuri.movieProject.still.repository;

import me.gyuri.movieProject.still.entity.Still;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StillRepository extends JpaRepository<Still, Long> {
}
