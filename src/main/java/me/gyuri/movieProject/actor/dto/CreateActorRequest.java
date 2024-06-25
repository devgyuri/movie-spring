package me.gyuri.movieProject.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.actor.Actor;
import me.gyuri.movieProject.movie.Movie;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateActorRequest {
    private String name;
    private String url;

    public Actor toEntity() {
        return Actor.builder()
                .name(name)
                .url(url)
                .build();
    }
}
