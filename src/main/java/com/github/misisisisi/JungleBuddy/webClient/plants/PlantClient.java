package com.github.misisisisi.JungleBuddy.webClient.plants;

import com.github.misisisisi.JungleBuddy.DTOs.PlantDto;
import com.github.misisisisi.JungleBuddy.webClient.plants.dto.MainPlantDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class PlantClient {
    private RestTemplate restTemplate = new RestTemplate();

    private static HttpEntity<Object> getObjectHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", System.getProperty("X-RapidAPI-Key"));
        headers.add("X-RapidAPI-Host", "house-plants.p.rapidapi.com");
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        return entity;
    }

    public PlantDto getPlantByLatinName(String latinName) {

        ResponseEntity<MainPlantDto[]> exchange = restTemplate.exchange("https://house-plants.p.rapidapi.com/latin/{name}", HttpMethod.GET, getObjectHttpEntity(), MainPlantDto[].class, latinName);
        MainPlantDto[] body = exchange.getBody();
        Optional<MainPlantDto> first = Arrays.stream(body).findFirst();
        MainPlantDto mainPlantDto = first.get();

        return PlantDto.builder()
                .latin(mainPlantDto.getLatin())
                .family(mainPlantDto.getFamily())
                .commonName(mainPlantDto.getCommon())
                .category(mainPlantDto.getCategory())
                .climate(mainPlantDto.getClimate())
                .maxTempInCelsius(mainPlantDto.getTempmax().getCelsius())
                .maxTempInFahrenheit(mainPlantDto.getTempmax().getFahrenheit())
                .minTempInCelsius(mainPlantDto.getTempmin().getCelsius())
                .minTempInFahrenheit(mainPlantDto.getTempmin().getFahrenheit())
                .idealLight(mainPlantDto.getIdeallight())
                .toleratedLight(mainPlantDto.getToleratedlight())
                .watering(mainPlantDto.getWatering())
                .insects(mainPlantDto.getInsects())
                .diseases(mainPlantDto.getDiseases())
                .use(mainPlantDto.getUse())
                .build();
    }

    public List<PlantDto> getAllPlants() {
        HttpEntity<Object> entity = getObjectHttpEntity();

        List<PlantDto> list = new ArrayList<>();
        ResponseEntity<MainPlantDto[]> exchange = restTemplate.exchange("https://house-plants.p.rapidapi.com/all", HttpMethod.GET, entity, MainPlantDto[].class);
        MainPlantDto[] body = exchange.getBody();

        for (MainPlantDto b : body) {
            PlantDto build = PlantDto.builder()
                    .latin(b.getLatin())
                    .family(b.getFamily())
                    .commonName(b.getCommon())
                    .category(b.getCategory())
                    .climate(b.getClimate())
                    .maxTempInCelsius(b.getTempmax().getCelsius())
                    .maxTempInFahrenheit(b.getTempmax().getFahrenheit())
                    .minTempInCelsius(b.getTempmin().getCelsius())
                    .minTempInFahrenheit(b.getTempmin().getFahrenheit())
                    .idealLight(b.getIdeallight())
                    .toleratedLight(b.getToleratedlight())
                    .watering(b.getWatering())
                    .insects(b.getInsects())
                    .diseases(b.getDiseases())
                    .use(b.getUse())
                    .build();
            list.add(build);
        }
        return list;
    }
}
