package com.github.misisisisi.JungleBuddy.webClient.plants.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiResponseDeserializer extends JsonDeserializer<ApiResponse> {

    @Override
    public ApiResponse deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        ApiResponse apiResponse = new ApiResponse();

        JsonNode node = parser.getCodec().readTree(parser);

        if (node.isTextual()) {
            // Jeśli to pojedynczy String, ustaw go jako wartość String w ApiResponse
            apiResponse.setData(node.asText());
        } else if (node.isArray()) {
            // Jeśli to lista, przekształć ją na listę Stringów
            List<String> dataList = new ArrayList<>();
            for (JsonNode elementNode : node) {
                dataList.add(elementNode.asText());
            }
            apiResponse.setData(dataList);
        }
        return apiResponse;
    }
}