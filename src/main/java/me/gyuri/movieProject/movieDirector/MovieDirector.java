package me.gyuri.movieProject.movieDirector;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.director.Director;
import me.gyuri.movieProject.movie.Movie;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieDirector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "id")
    private Director director;
}
