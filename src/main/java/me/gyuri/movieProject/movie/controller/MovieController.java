package me.gyuri.movieProject.movie.controller;

import lombok.RequiredArgsConstructor;
import me.gyuri.movieProject.movie.dto.CreateMovieRequest;
import me.gyuri.movieProject.movie.entity.Movie;
import me.gyuri.movieProject.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MovieController {
    private final MovieService movieService;

//    @GetMapping("/api/movie/")
//    public Movie fetchMovie(@Argument String code) {
//        return movieService.findMovieByCode(code);
//    }

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
