package me.gyuri.movieProject.actor.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.movieActor.entity.MovieActor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "actor")
    private List<MovieActor> movieActors = new ArrayList<>();

    @Builder
    public Actor(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
