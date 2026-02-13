package org.bedu.netflix.service;

import java.util.ArrayList;
import java.util.List;

import org.bedu.netflix.dto.DirectorDTO;
import org.bedu.netflix.entity.Director;
import org.bedu.netflix.mapper.DirectorMapper;
import org.bedu.netflix.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository repository;

    @Autowired
    private DirectorMapper mapper;

    public List<DirectorDTO> getDirectors() {
        List<Director> directors = repository.findAll();
        List<DirectorDTO> dtos = new ArrayList<>();
        for (Director director : directors) {
            dtos.add(mapper.toDTO(director));
        }
        return dtos;
    }
}