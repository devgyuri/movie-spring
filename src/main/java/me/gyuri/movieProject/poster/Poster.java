package me.gyuri.movieProject.poster;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.movie.Movie;
import org.hibernate.annotations.ColumnDefault;

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

    @Column(name = "is_rep")
    @ColumnDefault("false")
    private Boolean isRep;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "movieId")
    private Movie movie;

    @Builder
    public Poster(String url, boolean isRep) {
        this.url = url;
        this.isRep = isRep;
    }
}
