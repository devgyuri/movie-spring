package me.gyuri.movieProject.movie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.gyuri.movieProject.movie.dto.CreateMovieRequest;
import me.gyuri.movieProject.movie.entity.Movie;
import me.gyuri.movieProject.movie.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    MovieRepository movieRepository;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        movieRepository.deleteAll();
    }

    @DisplayName("fetchMovie: 영화 정보 조회에 성공한다.")
    @Test
    public void fetchMovie() throws Exception {
        // given
        final String url = "/api/movies/{code}";
        final String code = "code123";
        final String title = "title";
        final LocalDate openDt = LocalDate.of(2020, 3, 4);

        Movie savedMovie = movieRepository.save(Movie.builder()
                .code(code)
                .title(title)
                .openDt(openDt)
                .build());

        // when
        final ResultActions resultActions = mockMvc.perform(get(url, savedMovie.getCode()));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(code))
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.openDt").value(openDt.toString()));
    }

    @DisplayName("createMovie: 영화 정보 추가에 성공한다.")
    @Test
    public void createMovie() throws Exception {
        // given
        final String url = "/api/movie";
        final String code = "code";
        final String title = "title";
        final LocalDate openDt = LocalDate.of(2020, 3, 4);
        final CreateMovieRequest userRequest = new CreateMovieRequest(code, title, openDt);

        final String requestBody = objectMapper.writeValueAsString(userRequest);

        // when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        // then
        result.andExpect(status().isCreated());

        List<Movie> movies = movieRepository.findAll();

        assertThat(movies.size()).isEqualTo(1);
        assertThat(movies.get(0).getCode()).isEqualTo(code);
        assertThat(movies.get(0).getTitle()).isEqualTo(title);
        assertThat(movies.get(0).getOpenDt()).isEqualTo(openDt);
    }
}