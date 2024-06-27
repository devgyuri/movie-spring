package me.gyuri.movieProject.actor.service;

import lombok.RequiredArgsConstructor;
import me.gyuri.movieProject.actor.entity.Actor;
import me.gyuri.movieProject.actor.repository.ActorRepository;
import me.gyuri.movieProject.movie.dto.CreateActorInput;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ActorService {
    private final ActorRepository actorRepository;

    public Actor createActor(CreateActorInput request) {
        return actorRepository.save(request.toEntity());
    }
}
