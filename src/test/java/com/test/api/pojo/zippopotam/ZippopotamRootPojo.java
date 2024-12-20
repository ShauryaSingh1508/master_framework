package com.test.api.pojo.zippopotam;

import java.util.ArrayList;

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
public class ZippopotamRootPojo {


    @JsonProperty("post code") // Map "post code" from JSON to this field
    private String postCode;

    @JsonProperty("country")
    private String country;

    @JsonProperty("country abbreviation") // Map "country abbreviation" from JSON
    private String countryAbbreviation;

    @JsonProperty("places")
    private ArrayList<Zippopotampojo> places;

}
