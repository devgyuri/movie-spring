package me.gyuri.movieProject.poster.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.movie.entity.Movie;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Poster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "is_rep", nullable = false)
    private Boolean isRep;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Movie movie;

    @Builder
    public Poster(String url, boolean isRep) {
        this.url = url;
        this.isRep = isRep;
    }
}
