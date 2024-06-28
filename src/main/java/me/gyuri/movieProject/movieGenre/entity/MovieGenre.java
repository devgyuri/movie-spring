package me.gyuri.movieProject.movieGenre.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.genre.entity.Genre;
import me.gyuri.movieProject.movie.entity.Movie;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Genre genre;
}