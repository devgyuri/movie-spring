package me.gyuri.movieProject.comment;

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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "contents")
    private String contents;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "star")
    private Double star;

    @ManyToOne
    @JoinColumn(name = "id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @Builder
    public Comment(String contents, Date createdAt, Double star) {
        this.contents = contents;
        this.createdAt = createdAt;
        this.star = star;
    }
}
