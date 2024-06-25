package me.gyuri.movieProject.movieActor.service;

import lombok.RequiredArgsConstructor;
import me.gyuri.movieProject.movieActor.MovieActor;
import me.gyuri.movieProject.movieActor.dto.CreateMovieActorRequest;
import me.gyuri.movieProject.movieActor.repository.MovieActorRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieActorService {
    private final MovieActorRepository movieActorRepository;

    public MovieActor createMovieActor(CreateMovieActorRequest request) {
        return movieActorRepository.save(request.toEntity());
    }
}
