package me.gyuri.movieProject.director;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.movieActor.MovieActor;
import me.gyuri.movieProject.movieDirector.MovieDirector;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "director")
    private List<MovieDirector> movieDirectors = new ArrayList<>();

    @Builder
    public Director(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
