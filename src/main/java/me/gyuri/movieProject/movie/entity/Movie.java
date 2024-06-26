package me.gyuri.movieProject.movie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.movieActor.entity.MovieActor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Movie {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "open_dt", nullable = false)
    private LocalDate openDt;

    @OneToMany(mappedBy = "movie")
    private List<MovieActor> movieActors = new ArrayList<>();

    @Builder
    public Movie(String id, String title, LocalDate openDt) {
        this.id = id;
        this.title = title;
        this.openDt = openDt;
    }
}
