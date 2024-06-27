package me.gyuri.movieProject.movieActor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.actor.entity.Actor;
import me.gyuri.movieProject.movie.entity.Movie;
import me.gyuri.movieProject.movieActor.entity.MovieActor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateMovieActorInput {
    private Movie movie;
    private Actor actor;

    public MovieActor toEntity() {
        return MovieActor.builder()
                .movie(movie)
                .actor(actor)
                .build();
    }
}
