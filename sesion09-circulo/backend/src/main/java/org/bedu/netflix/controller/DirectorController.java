package org.bedu.netflix.controller;

import java.util.List;

import org.bedu.netflix.dto.DirectorDTO;
import org.bedu.netflix.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("directors")
public class DirectorController {

    @Autowired
    private DirectorService service;
 
    @GetMapping
    public List<DirectorDTO> getDirectors() {
        return service.getDirectors();
    }
}