package com.weskold.dslist.services;

import com.weskold.dslist.dto.GameMinDTO;
import com.weskold.dslist.entities.Game;
import com.weskold.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //ou @Componet // Usado para registrar a classe como um componente do sistema.
public class GameService {

    @Autowired // Usado para injetar o gamerepository dentro da class para ser usado.
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll(); // cria uma lista do tipo Game, que recebe uma consulta no DB feito automatico pelo o metodo do Framework Spring.
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // Faz a conversão da Lista result, para outra lista do tipo GameMinDTO, passando o X como parametro para criação, ou seja, para todo objeto X adicione na lista.
        return dto;
        //Caso queira resumir o return, pode usar a seguinte forma
        // return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}


