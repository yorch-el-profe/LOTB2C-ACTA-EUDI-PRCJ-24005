package org.bedu.netflix.controller;

import java.util.List;

import org.bedu.netflix.dto.ActorDTO;
import org.bedu.netflix.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("actors")
public class ActorController {

    @Autowired
    private ActorService service;
 
    @GetMapping
    public List<ActorDTO> getActors() {
        return service.getActors();
    }
}