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
import java.util.List;

@Component
public class PlantClient {
    public static final String URL = "https://house-plants.p.rapidapi.com";
    private RestTemplate restTemplate = new RestTemplate();

    private static HttpEntity<Object> getObjectHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", System.getProperty("X-RapidAPI-Key"));
        headers.add("X-RapidAPI-Host", "house-plants.p.rapidapi.com");
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        return entity;
    }

    private static List<PlantDto> getPlantDtoList(ResponseEntity<MainPlantDto[]> exchange) {
        MainPlantDto[] body = exchange.getBody();
        List<PlantDto> list = new ArrayList<>();

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


    public List<PlantDto> getPlants(String kindOfName,String name) {
        ResponseEntity<MainPlantDto[]> exchange = restTemplate.exchange(URL + "/{kindOfName}/{name}", HttpMethod.GET, getObjectHttpEntity(), MainPlantDto[].class, kindOfName, name);
        return getPlantDtoList(exchange);
    }
    public List<PlantDto> getPlantByLatinName(String latinName) {
        return getPlants("latin", latinName);
//        return getPlantDtoList(plants);
    }

    public List<PlantDto> getAllPlants() {
        ResponseEntity<MainPlantDto[]> exchange = restTemplate.exchange(URL + "/all", HttpMethod.GET, getObjectHttpEntity(), MainPlantDto[].class);
        return getPlantDtoList(exchange);
    }

    public List<PlantDto> getPlantByCommonName(String commonName) {
        return getPlants("common", commonName);
    }
}
