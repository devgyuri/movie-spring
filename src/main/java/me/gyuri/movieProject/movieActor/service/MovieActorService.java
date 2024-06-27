package me.gyuri.movieProject.movieActor.service;

import lombok.RequiredArgsConstructor;
import me.gyuri.movieProject.movieActor.entity.MovieActor;
import me.gyuri.movieProject.movieActor.dto.CreateMovieActorInput;
import me.gyuri.movieProject.movieActor.repository.MovieActorRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieActorService {
    private final MovieActorRepository movieActorRepository;

    public MovieActor createMovieActor(CreateMovieActorInput request) {
        return movieActorRepository.save(request.toEntity());
    }
}
