package com.concordia.microservices.QualitySettingsservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.HttpStatus;

@RestController
public class QualityController {

    @Autowired
    private QualityConfiguration qualityConfiguration;

    @GetMapping(value = "/quality-settings")
    public ResponseEntity<String> redirectToFreeQualitySettings() {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION, "/quality-settings/free")
                .build();
    }

    @GetMapping(value = "/quality-settings/{profile}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getQualitySettings(@PathVariable String profile) {
        try {
            QualitySettings.QualityData qualityData;
            switch (profile) {
                case "free":
                    qualityData = new QualitySettings.QualityData(
                            qualityConfiguration.getFreeMinBitrate(),
                            qualityConfiguration.getFreeMaxBitrate());
                    break;
                case "premium":
                    qualityData = new QualitySettings.QualityData(
                            qualityConfiguration.getPremiumMinBitrate(),
                            qualityConfiguration.getPremiumMaxBitrate());
                    break;
                case "vip":
                    qualityData = new QualitySettings.QualityData(
                            qualityConfiguration.getVipMinBitrate(),
                            qualityConfiguration.getVipMaxBitrate());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid profile: " + profile);
            }

            QualitySettings qualitySettings = new QualitySettings("quality-settings", profile, qualityData);
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            String json = mapper.writeValueAsString(qualitySettings);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            return new ResponseEntity<>(json, headers, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            String errorMessage = "Sorry";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        } catch (JsonProcessingException e) {
            String errorMessage = "Error processing JSON response";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


}
