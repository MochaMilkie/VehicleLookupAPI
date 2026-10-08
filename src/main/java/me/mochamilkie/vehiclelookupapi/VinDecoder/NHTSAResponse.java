package me.mochamilkie.vehiclelookupapi.VinDecoder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NHTSAResponse(@JsonProperty("Results") List<NHTSAResult> results) {}
