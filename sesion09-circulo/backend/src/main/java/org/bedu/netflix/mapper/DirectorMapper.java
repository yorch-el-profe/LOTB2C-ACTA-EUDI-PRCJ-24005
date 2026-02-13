package org.bedu.netflix.mapper;

import org.bedu.netflix.dto.CreateDirectorDTO;
import org.bedu.netflix.dto.DirectorDTO;
import org.bedu.netflix.entity.Director;
import org.springframework.stereotype.Component;

@Component
public class DirectorMapper {
    
    public Director toModel(CreateDirectorDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Director entity = new Director();
        entity.setName(dto.getName());
        return entity;
    }

    public DirectorDTO toDTO(Director entity) {
        DirectorDTO dto = new DirectorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}