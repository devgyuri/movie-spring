package me.gyuri.movieProject.movie.controller;

import lombok.RequiredArgsConstructor;
import me.gyuri.movieProject.movie.dto.CreateMovieRequest;
import me.gyuri.movieProject.movie.dto.MovieResponse;
import me.gyuri.movieProject.movie.entity.Movie;
import me.gyuri.movieProject.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/api/movies/{code}")
    public ResponseEntity<MovieResponse> fetchMovie(@PathVariable String code) {
        Movie movie = movieService.findMovieByCode(code);

        return ResponseEntity.ok()
                .body(new MovieResponse(movie));
    }

    @PostMapping("/api/movie")
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
