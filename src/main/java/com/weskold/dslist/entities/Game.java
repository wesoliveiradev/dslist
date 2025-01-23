package com.weskold.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity //Essa  notation configura a classe para ela ser equivalente a uma tabela do DB
@Table(name="tb_game") // Usado para fazer a criação da tabela e dentro do () passa o nome da tabela.

public class Game {

    @Id // Usado antes do atributo que precisa ser o PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para que o Id seja auto increment usa o GeneratedValue
    private Long id;
    private String title;

    @Column(name = "game_year") //Usa o comando @Column seguido dos atributos name ="" para qunado o DB for criado, utilizar o nome passado dentro do ().
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;

    @Column(columnDefinition = "TEXT") // Cria a columa do tipo texto, sem essa notation será criado como VARCHAR(255)
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String longDescription;

    public Game(){

    }

    public Game(Long id, String title, Integer year, String genre, String platform, Double score, String imgUrl, String shortDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platform;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

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

    public void setPlatforms(String platform) {
        this.platforms = platform;
    }

    public Double getScore(){
        return score;
    }

    public void setScore(Double score){
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Game other = (Game) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
