package me.gyuri.movieProject.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.movie.entity.Movie;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CreateMovieInput {
    private String id;
    private String title;
    private LocalDate openDt;

    public Movie toEntity() {
        return Movie.builder()
                .id(id)
                .title(title)
                .openDt(openDt)
                .build();
    }
}
