package com.github.misisisisi.JungleBuddy.DTOs;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PlantDto {
    private String latin;
    private String family;
    private List<String> commonName;
    private String category;
    private String climate;
    private int maxTempInCelsius;
    private double maxTempInFahrenheit;
    private int minTempInCelsius;
    private double minTempInFahrenheit;
    private String idealLight;
    private String toleratedLight;
    private String watering;
    private String insects;
    private String diseases;
    private List<String> use;
}
