package me.gyuri.movieProject.movie.dto;

import lombok.Getter;
import me.gyuri.movieProject.movie.entity.Movie;

import java.time.LocalDate;

@Getter
public class MovieResponse {
    private final String code;
    private final String title;
    private final LocalDate openDt;

    public MovieResponse(Movie movie) {
        this.code = movie.getCode();
        this.title = movie.getTitle();
        this.openDt = movie.getOpenDt();
    }
}
