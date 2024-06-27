package me.gyuri.movieProject.movie.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.movieActor.entity.MovieActor;
import me.gyuri.movieProject.movieBoxOffice.entity.MovieBoxOffice;
import me.gyuri.movieProject.movieDirector.entity.MovieDirector;
import me.gyuri.movieProject.movieGenre.entity.MovieGenre;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "open_dt", nullable = false)
    private LocalDate openDt;

    @Column(name = "avg_star")
    @ColumnDefault("0")
    private Float avgStar;

    @Column(name = "cnt_star")
    @ColumnDefault("0")
    private Integer cntStar;

    @Column(name = "rating")
    @ColumnDefault("0")
    private Integer rating;

    @Column(name = "plot")
    private String plot;

    @Column(name = "runtime")
    private Integer runtime;

    @OneToMany(mappedBy = "movie")
    private List<MovieBoxOffice> movieBoxOffices = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<MovieActor> movieActors = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<MovieDirector> movieDirectors = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> moviegenres = new ArrayList<>();



    @Builder
    public Movie(String code, String title, LocalDate openDt, int rating, String plot, int runtime) {
        this.code = code;
        this.title = title;
        this.openDt = openDt;
        this.rating = rating;
        this.plot = plot;
        this.runtime = runtime;
    }
}
