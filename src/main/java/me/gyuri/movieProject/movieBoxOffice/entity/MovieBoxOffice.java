package me.gyuri.movieProject.movieBoxOffice.entity;

import jakarta.persistence.*;
import lombok.*;
import me.gyuri.movieProject.boxOffice.entity.BoxOffice;
import me.gyuri.movieProject.movie.entity.Movie;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieBoxOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "ranking")
    @ColumnDefault("0")
    private Integer ranking;

    @Column(name = "audi_acc")
    @ColumnDefault("0")
    private Integer audiAcc;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Movie movie;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private BoxOffice boxOffice;

//    @Builder
//    public MovieBoxOffice(int rank, int audiAcc, Movie movie, BoxOffice boxOffice) {
//        this.rank = rank;
//        this.audiAcc = audiAcc;
//        this.movie = movie;
//        this.boxOffice = boxOffice;
//    }
}
