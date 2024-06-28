package me.gyuri.movieProject.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.gyuri.movieProject.movie.entity.Movie;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CreateMovieRequest {
    private String code;
    private String title;
    private LocalDate openDt;

    public Movie toEntity() {
        return Movie.builder()
                .code(code)
                .title(title)
                .openDt(openDt)
                .build();
    }
}
