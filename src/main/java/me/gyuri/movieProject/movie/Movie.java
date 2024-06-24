package me.gyuri.movieProject.movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.comment.Comment;
import me.gyuri.movieProject.like.Like;
import me.gyuri.movieProject.movieActor.MovieActor;
import me.gyuri.movieProject.movieBoxOffice.MovieBoxOffice;
import me.gyuri.movieProject.movieDirector.MovieDirector;
import me.gyuri.movieProject.movieGenre.MovieGenre;
import me.gyuri.movieProject.poster.Poster;
import me.gyuri.movieProject.seen.Seen;
import me.gyuri.movieProject.still.Still;
import me.gyuri.movieProject.vod.Vod;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
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

    @Column(name = "open_dt")
    private Date openDt;

    @Column(name = "avg_star")
    @ColumnDefault("0")
    private Double avgStar;

    @Column(name = "cnt_star")
    @ColumnDefault("0")
    private Integer cntStar;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "plot")
    private String plot;

    @Column(name = "runtime")
    private Integer runtime;

    @OneToMany(mappedBy = "movie")
    private List<MovieBoxOffice> movieBoxOffices = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> moviegenres = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<MovieActor> movieActors = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<MovieDirector> movieDirectors = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Poster> posters = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Still> stills = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Vod> vods = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Seen> seens = new ArrayList<>();

    @Builder
    public Movie(String id, String title, Date openDt, int rating, String plot, int runtime) {
        this.id = id;
        this.title = title;
        this.openDt = openDt;
        this.rating = rating;
        this.plot = plot;
        this.runtime = runtime;
    }
}
