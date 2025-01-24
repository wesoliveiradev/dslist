package com.weskold.dslist.dto;

import com.weskold.dslist.entities.Game;
import org.springframework.beans.BeanUtils;

public class GameDTO {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO() {
    }

    public GameDTO(Game entity){ //Usamos a classe utilitária do framwork (BEANUTILS) que agiliza a copia dos atributos de uma classe para o construtor.
        BeanUtils.copyProperties(entity, this); //Como parametro passamos primeiro a clase que será copiado os atributos e depois a classe que vai receber, no caso a mesma que estamos trabalhando, por isso fica apenas THIS.
    }

    //Abaixo, seria o mesmo procedimento feito acima, mas de forma manual.
    /*public GameDTO(Game entity) {
        longDescription = entity.getLongDescription();
        shortDescription = entity.getShortDescription();
        imgUrl = entity.getImgUrl();
        score = entity.getScore();
        platforms = entity.getPlatforms();
        genre = entity.getGenre();
        year = entity.getYear();
        title = entity.getTitle();
        id = entity.getId();
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
