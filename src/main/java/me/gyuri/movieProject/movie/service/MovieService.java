package me.gyuri.movieProject.movie.service;

import lombok.RequiredArgsConstructor;
import me.gyuri.movieProject.actor.entity.Actor;
import me.gyuri.movieProject.actor.service.ActorService;
import me.gyuri.movieProject.movie.entity.Movie;
import me.gyuri.movieProject.movie.dto.CreateActorInput;
import me.gyuri.movieProject.movie.dto.CreateMovieInput;
import me.gyuri.movieProject.movie.repository.MovieRepository;
import me.gyuri.movieProject.movieActor.dto.CreateMovieActorInput;
import me.gyuri.movieProject.movieActor.service.MovieActorService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final ActorService actorService;
    private final MovieActorService movieActorService;

    public Movie findMovieByCode(String code) {
        return movieRepository.findTop1ByCode(code);
    }

    public Movie createMovie(CreateMovieInput createMovieInput) {
        return movieRepository.save(createMovieInput.toEntity());
    }

    public Movie createMovieRelationData(CreateMovieInput createMovieInput) {
        Movie savedMovie = movieRepository.save(createMovieInput.toEntity());
        Actor savedActor = actorService.createActor(new CreateActorInput("actor name 1", "url1"));
        movieActorService.createMovieActor(new CreateMovieActorInput(savedMovie, savedActor));
        return savedMovie;
    }
}
