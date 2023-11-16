package com.github.misisisisi.JungleBuddy.service;

import com.github.misisisisi.JungleBuddy.DTOs.PlantDto;
import com.github.misisisisi.JungleBuddy.webClient.plants.PlantClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlantService {

    private final PlantClient plantClient;

    public PlantDto getByLatinName(String latinName) {
        PlantDto plantByLatinName = plantClient.getPlantByLatinName(latinName);
        return plantByLatinName;
    }

    public List<PlantDto> getALlPlants() {
        List<PlantDto> allPlants = plantClient.getAllPlants();
        return allPlants;
    }
}
