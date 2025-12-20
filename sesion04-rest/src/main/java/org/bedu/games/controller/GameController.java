package org.bedu.games.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.bedu.games.model.Game;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Nota: Un backend es un API pero un API no siempre es un backend.
 * 
 * API: Application Programming Interface
 * En un software que permite conectar otro software
 * 
 * SDK: Software Development Kit
 * Un conjunto de herramientas 
 * 
 * Idea:
 * 
 * Administrar información de videojuegos.
 *  - Obtener información de un videojuego en específico (Path Variable)
 *  - Obtener información de todos los videojuegos
 *  - Dar de alta nuevos videojuegos (Body)
 *  - Editar videojuegos (Body)
 *  - Dar de baja videojuegos (Path Variable)
 * 
 * CRUD (Create, Read, Update, Delete)
 * 
 * Un CRUD es un API/Backend que realiza dichas operaciones.
 */

@RestController
public class GameController {
    
    private int currentId = 3;
    private List<Game> db = new LinkedList<>();

    public GameController() {
        // En memoria
        db.add(new Game(1, "Super Mario 64", 1996, "Platform"));
        db.add(new Game(2, "The King of Fighters 95", 1995, "Fightning"));
        db.add(new Game(3, "The Legend of Zelda: A Link to the Past", 1992, "Adventure"));
    }

    /**
     * Formas de pasar parámetros a un API (4)
     * 
     * 1. Querystring (@RequestParam)
     * 
     *  http://localhost:8080/endpoint ? param1 = valor1 & param2 = valor2 & ...
     * 
     * 2. Path Variable (@PathVariable)
     * 
     *  http://loalhost:8080/endpoint/{variable}
     * 
     * 3. Request Body (@RequestBody)
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

    @RequestMapping("deleteGame/{id}")
    public void deleteOne(@PathVariable("id") int id) {
        for (int i = 0; i < db.size(); i++) {
            Game game = db.get(i);

            if (game.getId() == id) {
                db.remove(i);
                break;
            }
        }
    }

    // ++currentId: Incrementa en uno y luego asigna el valor
    // currentId++: Asigna el valor y luego incrementa en uno
    @RequestMapping("createGame")
    public int create(@RequestBody Game newGame) {
        System.out.println(newGame);
        newGame.setId(++currentId);
        db.add(newGame);
        return newGame.getId();
    }

    @RequestMapping("updateGame/{id}")
    public void update(@RequestBody Game updatedGame, @PathVariable("id") int id) {
        for (Game game : db) {
            if (game.getId() == id) {

                if (updatedGame.getTitle() != null) {
                    game.setTitle(updatedGame.getTitle());
                }

                if (updatedGame.getYear() != null) {
                    game.setYear(updatedGame.getYear());
                }

                if (updatedGame.getGenre() != null) {
                    game.setGenre(updatedGame.getGenre());
                }

                break;
            }
        }
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