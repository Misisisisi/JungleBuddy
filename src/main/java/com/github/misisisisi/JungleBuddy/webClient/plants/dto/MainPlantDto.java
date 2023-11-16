package com.github.misisisisi.JungleBuddy.webClient.plants.dto;

import com.github.misisisisi.JungleBuddy.webClient.plants.deserialization.ApiResponse;
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
    private ApiResponse insects; //API zwraca albo String albo Listę dlatego dodatkowa klasa ApiResponse do ręcznej deserializacji
    private ApiResponse diseases;
    private ApiResponse use;

}
