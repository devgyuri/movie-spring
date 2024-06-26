package me.gyuri.movieProject.movieActor.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.actor.entity.Actor;
import me.gyuri.movieProject.movie.entity.Movie;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Actor actor;

    @Builder
    public MovieActor(Movie movie, Actor actor) {
        this.movie = movie;
        this.actor = actor;
    }
}
