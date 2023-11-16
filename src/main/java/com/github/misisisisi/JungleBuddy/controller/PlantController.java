package com.github.misisisisi.JungleBuddy.controller;

import com.github.misisisisi.JungleBuddy.DTOs.PlantDto;
import com.github.misisisisi.JungleBuddy.service.PlantService;
import com.github.misisisisi.JungleBuddy.webClient.plants.dto.MainPlantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlantController {

    private final PlantService plantService;

    @GetMapping("/{name}")
    public PlantDto getByLatin(@PathVariable("name") String latinName){
        return plantService.getByLatinName(latinName);
    }

    @GetMapping("/all")
    public List<PlantDto> getAllPlant(){
        return plantService.getALlPlants();
    }
}
