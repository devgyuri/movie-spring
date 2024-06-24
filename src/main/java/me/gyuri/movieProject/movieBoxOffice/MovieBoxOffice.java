package me.gyuri.movieProject.movieBoxOffice;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.boxOffice.BoxOffice;
import me.gyuri.movieProject.movie.Movie;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieBoxOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "rank")
    private int rank;

    @Column(name = "audi_acc")
    @ColumnDefault("0")
    private int audiAcc;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id", name = "movieId")
    private Movie movie;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id", name = "boxOfficeId")
    private BoxOffice boxOffice;

    @Builder
    public MovieBoxOffice(int rank, int audiAcc) {
        this.rank = rank;
        this.audiAcc = audiAcc;
    }
}
