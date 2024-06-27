package me.gyuri.movieProject.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.gyuri.movieProject.actor.entity.Actor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateActorInput {
    private String name;
    private String url;

    public Actor toEntity() {
        return Actor.builder()
                .name(name)
                .url(url)
                .build();
    }
}
