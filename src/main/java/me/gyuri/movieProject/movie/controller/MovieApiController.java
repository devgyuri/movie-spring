package me.gyuri.movieProject.movie.controller;

import lombok.RequiredArgsConstructor;
import me.gyuri.movieProject.movie.Movie;
import me.gyuri.movieProject.movie.dto.CreateMovieRequest;
import me.gyuri.movieProject.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MovieApiController {
    private final MovieService movieService;

    @PostMapping("/api/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody CreateMovieRequest request) {
        Movie savedMovie = movieService.createMovie(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedMovie);
    }

    @PostMapping("/api/test")
    public ResponseEntity<Movie> createMovieRelationData(@RequestBody CreateMovieRequest request) {
        Movie savedMovie = movieService.createMovieRelationData(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedMovie);
    }
}
