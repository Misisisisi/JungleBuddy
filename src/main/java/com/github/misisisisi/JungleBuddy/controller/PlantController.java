package com.github.misisisisi.JungleBuddy.controller;

import com.github.misisisisi.JungleBuddy.DTOs.PlantDto;
import com.github.misisisisi.JungleBuddy.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlantController {

    private final PlantService plantService;

    @GetMapping("/all")
    public List<PlantDto> getAllPlant(){
        return plantService.getALlPlants();
    }
    @GetMapping("/latin/{name}")
    public List<PlantDto> getByLatin(@PathVariable("name") String latinName){
        return plantService.getByLatinName(latinName);
    }
    @GetMapping("/common/{name}")
    public List<PlantDto> getByCommon(@PathVariable("name") String commonName){
        return plantService.getByCommonName(commonName);
    }
      @GetMapping("/category/{category}")
    public List<PlantDto> getByCategory(@PathVariable("category") String category){
        return plantService.getByCategory(category);
    }

    @GetMapping("/origin/{origin}")
    public List<PlantDto> getByOrigin(@PathVariable("origin") String origin){
        return plantService.getByOrigin(origin);
    }

}
