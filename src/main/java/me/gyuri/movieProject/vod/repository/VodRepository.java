package me.gyuri.movieProject.vod.repository;

import me.gyuri.movieProject.vod.entity.Vod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VodRepository extends JpaRepository<Vod, Long> {
}
