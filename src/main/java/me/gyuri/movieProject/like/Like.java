package me.gyuri.movieProject.like;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.movie.Movie;
import me.gyuri.movieProject.user.User;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "movieId")
    private Movie movie;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "userId")
    private User user;
}
