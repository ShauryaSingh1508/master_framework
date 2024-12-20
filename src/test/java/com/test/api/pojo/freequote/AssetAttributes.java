
package com.test.api.pojo.freequote;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Setter
@Getter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("jsonschema2pojo")
public class AssetAttributes {

    @JsonProperty("attributes")
    private List<Attribute> attributes = null;

}
