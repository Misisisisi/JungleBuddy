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

    public List<PlantDto> getALlPlants() {
        return plantClient.getAllPlants();
    }

    public List<PlantDto> getByLatinName(String latinName) {
        return plantClient.getPlantByLatinName(latinName);
    }

    public List<PlantDto> getByCommonName(String commonName) {
        return  plantClient.getPlantByCommonName(commonName);
    }

    public List<PlantDto> getByCategory(String categoryName) {
        return  plantClient.getPlantByCategory(categoryName);
    }


}
