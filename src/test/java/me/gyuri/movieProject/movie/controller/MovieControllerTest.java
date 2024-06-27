package me.gyuri.movieProject.movie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.gyuri.movieProject.movie.entity.Movie;
import me.gyuri.movieProject.movie.dto.CreateMovieInput;
import me.gyuri.movieProject.movie.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.GraphQlResponse;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureHttpGraphQlTester
class MovieControllerTest {
    @Autowired
    protected HttpGraphQlTester graphQlTester;

    @Autowired
    MovieRepository movieRepository;

    @BeforeEach
    public void testerSetUp() {
        graphQlTester = graphQlTester.mutate()
                        .build();
        movieRepository.deleteAll();
    }

    @DisplayName("createMovie: 영화 정보 추가에 성공한다.")
    @Test
    public void createMovie() throws Exception {
        // given
        final String code = "code";
        final String title = "title";
        final LocalDate date = LocalDate.of(2020, 3, 4);

        // when
        this.graphQlTester.documentName("createMovie")
                .variable("code", code)
                .variable("title", title)
                .variable("openDt", date)
                .execute();

        // then
        List<Movie> movies = movieRepository.findAll();

        assertThat(movies.size()).isEqualTo(1);
        assertThat(movies.get(0).getCode()).isEqualTo(code);
        assertThat(movies.get(0).getTitle()).isEqualTo(title);
        assertThat(movies.get(0).getOpenDt()).isEqualTo(date);
    }

    @DisplayName("createMovieInputType: 영화 정보 추가에 성공한다. (withDTO)")
    @Test
    public void createMovieInputType() throws Exception {
        // given
        final String code = "code";
        final String title = "title";
        final LocalDate date = LocalDate.of(2020, 3, 4);
        final CreateMovieInput userInput = new CreateMovieInput(code, title, date);

        // when
        this.graphQlTester.documentName("createMovieInputType")
                .variable("input", userInput)
                .execute();

        // then
        List<Movie> movies = movieRepository.findAll();

        assertThat(movies.size()).isEqualTo(1);
        assertThat(movies.get(0).getCode()).isEqualTo(code);
        assertThat(movies.get(0).getTitle()).isEqualTo(title);
        assertThat(movies.get(0).getOpenDt()).isEqualTo(date);
    }
}