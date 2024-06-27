package me.gyuri.movieProject.movieDirector.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.director.entity.Director;
import me.gyuri.movieProject.movie.entity.Movie;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieDirector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "movieId")
    private Movie movie;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "directorId")
    private Director director;
}
