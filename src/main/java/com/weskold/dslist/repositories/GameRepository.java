package com.weskold.dslist.repositories;

import com.weskold.dslist.entities.Game;
import com.weskold.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    //Para funcionar a consulta SQL puro (nativo) precisa de colocar a condição nativeQuery no parametro para funcionar a consulta abaixo
    //Uma observação, é que que o resultado da nativeQuery é uma interface, que no caso aqui no Java chama-se como Projection
    // Na interface precisa de ter métodos para cada consulta feita na query
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""") // O parametro que foi passado no metodo abaixo, é o mesmo usado na linha do Where, para ser consultado corretamente
    List<GameMinProjection> searchByList(Long listId);
}
