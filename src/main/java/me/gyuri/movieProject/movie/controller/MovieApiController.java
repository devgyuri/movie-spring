package me.gyuri.movieProject.movie.controller;

import lombok.RequiredArgsConstructor;
import me.gyuri.movieProject.movie.entity.Movie;
import me.gyuri.movieProject.movie.dto.CreateMovieInput;
import me.gyuri.movieProject.movie.service.MovieService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@RequiredArgsConstructor
@Controller
public class MovieApiController {
    private final MovieService movieService;

    @QueryMapping
    public String graphQlTest() {
        return "Hello, world!";
    }

    @MutationMapping
    public Movie createMovie(@Argument String id, @Argument String title, @Argument LocalDate openDt) {
        return movieService.createMovie(new CreateMovieInput(id, title, openDt));
    }

    @MutationMapping
    public Movie createMovieInputType(@Argument CreateMovieInput input) {
        return movieService.createMovie(input);
    }

//    @QueryMapping
//    public Movie createMovieRelationData(@Argument String id, @Argument String title, @Argument Date openDt) {
//        return movieService.createMovieRelationData(new CreateMovieRequest(id, title, openDt));
//    }
}
