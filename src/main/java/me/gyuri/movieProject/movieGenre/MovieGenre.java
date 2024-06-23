package me.gyuri.movieProject.movieGenre;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.genre.Genre;
import me.gyuri.movieProject.movie.Movie;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "genre")
    private Genre genre;
}
