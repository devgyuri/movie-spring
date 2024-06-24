package me.gyuri.movieProject.movie.service;

import lombok.RequiredArgsConstructor;
import me.gyuri.movieProject.movie.Movie;
import me.gyuri.movieProject.movie.dto.AddMovieRequest;
import me.gyuri.movieProject.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie createMovie(AddMovieRequest request) {
        return movieRepository.save(request.toEntity());
    }
}