package me.gyuri.movieProject.boxOffice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.movieBoxOffice.entity.MovieBoxOffice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoxOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @OneToMany(mappedBy = "boxOffice")
    private List<MovieBoxOffice> movieBoxOffices = new ArrayList<>();

    @Builder
    public BoxOffice(LocalDate date) {
        this.date = date;
    }
}