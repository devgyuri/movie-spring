package me.gyuri.movieProject.still;

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
public class Still {
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
    @JoinColumn(name = "id")
    private Movie movie;

    @Builder
    public Still(String url, boolean isRep) {
        this.url = url;
        this.isRep = isRep;
    }
}