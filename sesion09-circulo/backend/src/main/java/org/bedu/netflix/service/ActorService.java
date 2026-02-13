package org.bedu.netflix.service;

import java.util.ArrayList;
import java.util.List;

import org.bedu.netflix.dto.ActorDTO;
import org.bedu.netflix.entity.Actor;
import org.bedu.netflix.mapper.ActorMapper;
import org.bedu.netflix.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    @Autowired
    private ActorRepository repository;

    @Autowired
    private ActorMapper mapper;

    public List<ActorDTO> getActors() {
        List<Actor> actors = repository.findAll();
        List<ActorDTO> dtos = new ArrayList<>();
        for (Actor actor : actors) {
            dtos.add(mapper.toDTO(actor));
        }
        return dtos;
    }
}