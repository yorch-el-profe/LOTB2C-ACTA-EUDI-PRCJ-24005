package org.bedu.games.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.bedu.games.model.Game;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Idea:
 * 
 * Administrar información de videojuegos.
 *  - Obtener información de un videojuego en específico
 *  - Obtener información de todos los videojuegos
 *  - Dar de alta nuevos videojuegos
 *  - Editar videojuegos
 *  - Dar de baja videojuegos
 * 
 * CRUD (Create, Read, Update, Delete)
 * 
 * Un CRUD es un API/Backend que realiza dichas operaciones.
 */

@RestController
public class GameController {
    
    private List<Game> db = new LinkedList<>();

    public GameController() {
        db.add(new Game(1, "Super Mario 64", 1996, "Platform"));
        db.add(new Game(2, "The King of Fighters 95", 1995, "Fightning"));
        db.add(new Game(3, "The Legend of Zelda: A Link to the Past", 1992, "Adventure"));
    }

    /**
     * Formas de pasar parámetros a un API (4)
     * 
     * 1. Querystring
     * 
     *  http://localhost:8080/endpoint ? param1 = valor1 & param2 = valor2 & ...
     * 
     * 2. Path Variable
     * 
     *  http://loalhost:8080/endpoint/{variable}
     */

    // Obtener la información de todos los videojuegos
    @RequestMapping("getAllGames")
    public List<Game> getAll() {
        return db;
    }

    // Obtener la información de un videojuego en específico
    @RequestMapping("getOneGame/{id}")
    public Game getOne(@PathVariable("id") int id) {
        for (Game game : db) {
            if (game.getId() == id) {
                return game;
            }
        }

        return null;
    }

}

/**
 * For tradicional: Se usa una variable y se incrementa/decrementa de uno en uno
 * for (int i = 0; i < db.size(); i++) {
 *      Game game = db.get(i); 
 * }
 * 
 * 
 * For each: No nos interesa la posición, sólo el objeto
 * for (Game game : db) {
 * }
 */