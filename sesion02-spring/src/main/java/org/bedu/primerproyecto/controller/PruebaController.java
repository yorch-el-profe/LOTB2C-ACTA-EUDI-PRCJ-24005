package org.bedu.primerproyecto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * El controlador (Controller) es el cerebro de un backend
 * Decide qué hacer para resolver la petición.
 * 
 * Tiene un conjunto de "endpoints".
 */

@RestController
public class PruebaController {
    
    // URL: http://localhost:8080/hello
    @RequestMapping("hello")
    public String helloWorld() {
        return "Hello World";
    }
 
    // URL: http://localhost:8080/goodbye
    @RequestMapping("goodbye")
    public String goodByeWorld() {
        return "Goodbye World";
    }
}
