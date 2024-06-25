package me.gyuri.movieProject.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.movie.Movie;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateMovieRequest {
    private String id;
    private String title;

    public Movie toEntity() {
        return Movie.builder()
                .id(id)
                .title(title)
                .openDt(new Date())
                .build();
    }
}
