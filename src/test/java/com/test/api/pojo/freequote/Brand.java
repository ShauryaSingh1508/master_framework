
package com.test.api.pojo.freequote;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("jsonschema2pojo")
public class Brand{

    @JsonProperty("name")
    private String name;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("schemaId")
    private String schemaId;
    @JsonProperty("assets")
    private List<Object> assets;
    @JsonProperty("descrition")
    private Object descrition;
    @JsonProperty("displayOrder")
    private Integer displayOrder;
    @JsonProperty("webImageUrl")
    private String webImageUrl;
    @JsonProperty("imageWebUrl")
    private String imageWebUrl;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private List<Datum> data;



}
