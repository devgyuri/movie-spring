package me.gyuri.movieProject.movieActor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.actor.Actor;
import me.gyuri.movieProject.movie.Movie;
import me.gyuri.movieProject.movieActor.MovieActor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateMovieActorRequest {
    private Movie movie;
    private Actor actor;

    public MovieActor toEntity() {
        return MovieActor.builder()
                .movie(movie)
                .actor(actor)
                .build();
    }
}
