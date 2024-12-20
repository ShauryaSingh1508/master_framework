package com.test.api.pojo.zippopotam;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;


@Setter
@Getter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Zippopotampojo {

    @JsonProperty("place name")
    private String placeName;

    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("state")
    private String state;

    @JsonProperty("state abbreviation")
    private String stateAbbreviation;

    @JsonProperty("latitude")
    private String latitude;


}
