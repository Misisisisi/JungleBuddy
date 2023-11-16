package com.github.misisisisi.JungleBuddy.webClient.plants.deserialization;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonDeserialize(using = ApiResponseDeserializer.class)
public class ApiResponse {

    private Object data; // Może zawierać zarówno String, jak i List<String>
}

