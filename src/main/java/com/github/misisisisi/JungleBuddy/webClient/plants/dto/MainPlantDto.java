package com.github.misisisisi.JungleBuddy.webClient.plants.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MainPlantDto {

    private String latin;
    private String family;
    private List<String> common;
    private String category;
    private String climate;
    private TempMaxDto tempmax;
    private TempMinDto tempmin;
    private String ideallight;
    private String toleratedlight;
    private String watering;
//    private String insects;
//    private String diseases;
//    private List<String> use;

}
