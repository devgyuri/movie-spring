package me.gyuri.movieProject.movie.service;

import lombok.RequiredArgsConstructor;
import me.gyuri.movieProject.actor.entity.Actor;
import me.gyuri.movieProject.actor.service.ActorService;
import me.gyuri.movieProject.movie.entity.Movie;
import me.gyuri.movieProject.movie.dto.CreateActorRequest;
import me.gyuri.movieProject.movie.dto.CreateMovieInput;
import me.gyuri.movieProject.movie.repository.MovieRepository;
import me.gyuri.movieProject.movieActor.dto.CreateMovieActorRequest;
import me.gyuri.movieProject.movieActor.service.MovieActorService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ActorService actorService;
    private final MovieActorService movieActorService;

    public Movie createMovie(CreateMovieInput input) {
        return movieRepository.save(input.toEntity());
    }

    public Movie createMovieRelationData(CreateMovieInput request) {
        Movie savedMovie = movieRepository.save(request.toEntity());
        Actor savedActor = actorService.createActor(new CreateActorRequest("actor name 1", "url1"));
        movieActorService.createMovieActor(new CreateMovieActorRequest(savedMovie, savedActor));
        return savedMovie;
    }
}
