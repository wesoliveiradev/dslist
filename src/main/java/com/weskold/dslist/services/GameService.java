package com.weskold.dslist.services;

import com.weskold.dslist.dto.GameDTO;
import com.weskold.dslist.dto.GameMinDTO;
import com.weskold.dslist.entities.Game;
import com.weskold.dslist.projections.GameMinProjection;
import com.weskold.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //ou @Componet // Usado para registrar a classe como um componente do sistema.
public class GameService {

    @Autowired // Usado para injetar o gamerepository dentro da class para ser usado.
    private GameRepository gameRepository;

    //Transactional tem que ser do Spring e não do Jakarta
    @Transactional(readOnly = true)// é uma boa prática colocar essa notation em todos métodos do service para que fique transacional, para que garanta que a operação vai acontecer, obedecendo aos principios das transações, que é o ACID (Atomica consistente isolada e durável)
    //Deixamos o parametro de ReadOnly = true pois nesse momento não iremos fazer escrita no DB, apenas consulta.
    public GameDTO findById(Long id){ //fazer um tratamento para ID errado.
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll(); // cria uma lista do tipo Game, que recebe uma consulta no DB feito automatico pelo o metodo do Framework Spring.
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // Faz a conversão da Lista result, para outra lista do tipo GameMinDTO, passando o X como parametro para criação, ou seja, para todo objeto X adicione na lista.
        return dto;
        //Caso queira resumir o return, pode usar a seguinte forma
        // return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }


}


