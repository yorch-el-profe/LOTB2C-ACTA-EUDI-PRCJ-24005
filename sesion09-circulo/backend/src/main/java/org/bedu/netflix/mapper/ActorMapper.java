package org.bedu.netflix.mapper;

import org.bedu.netflix.dto.ActorDTO;
import org.bedu.netflix.dto.CreateActorDTO;
import org.bedu.netflix.entity.Actor;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {
    
    public Actor toModel(CreateActorDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Actor entity = new Actor();
        entity.setName(dto.getName());
        return entity;
    }

    public ActorDTO toDTO(Actor entity) {
        ActorDTO dto = new ActorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}