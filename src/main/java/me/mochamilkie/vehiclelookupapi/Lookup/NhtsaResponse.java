package me.mochamilkie.vehiclelookupapi.Lookup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NhtsaResponse(@JsonProperty("Results") List<NhtsaResult> results) {

}