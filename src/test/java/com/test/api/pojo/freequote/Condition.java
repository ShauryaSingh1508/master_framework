
package com.test.api.pojo.freequote;

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
//@Generated("jsonschema2pojo")
public class Condition {

    @JsonProperty("percentValue")
    private Integer percentValue;
    @JsonProperty("condition")
    private String condition;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("description")
    private String description;

}
