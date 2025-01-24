package com.weskold.dslist.controllers;


import com.weskold.dslist.dto.GameDTO;
import com.weskold.dslist.dto.GameMinDTO;
import com.weskold.dslist.entities.Game;
import com.weskold.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Configura a class para ser um controlador

@RequestMapping(value = "/games") //Mapear o recurso que deseja ser retornado, no caso o nome da "página" que será retornado.

public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById (@PathVariable Long id){ //Para que seja aceito o valor do ID que está vindo da requisição, precisa de colocar a notation @PathVariable antes do parametro.
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping // Configurado para que tenha o verbo GET para ser feito apenas busca dos dados.
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
