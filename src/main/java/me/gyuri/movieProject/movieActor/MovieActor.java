package me.gyuri.movieProject.movieActor;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.actor.Actor;
import me.gyuri.movieProject.movie.Movie;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "movieId")
    private Movie movie;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "actorId")
    private Actor actor;
}
