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
public class MovieController {
    private final MovieService movieService;

    @QueryMapping
    public Movie fetchMovie(@Argument String code) {
        return movieService.findMovieByCode(code);
    }

    @MutationMapping
    public Movie createMovie(@Argument String code, @Argument String title, @Argument LocalDate openDt) {
        return movieService.createMovie(new CreateMovieInput(code, title, openDt));
    }

    @MutationMapping
    public Movie createMovieInputType(@Argument CreateMovieInput createMovieInput) {
        return movieService.createMovie(createMovieInput);
    }

//    @QueryMapping
//    public Movie createMovieRelationData(@Argument String id, @Argument String title, @Argument Date openDt) {
//        return movieService.createMovieRelationData(new CreateMovieRequest(id, title, openDt));
//    }
}
