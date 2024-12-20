
package com.test.api.pojo.freequote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("jsonschema2pojo")
public class Datum {

    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("categoryName")
    private String categoryName;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("feeStructureId")
    private String feeStructureId;
    @JsonProperty("itemConditionId")
    private String itemConditionId;
    @JsonProperty("brands")
    private List<Brand> brands = null;
    @JsonProperty("bidType")
    private String bidType;
    @JsonProperty("type")
    private String type;
    @JsonProperty("webImageUrl")
    private String webImageUrl;
    @JsonProperty("group")
    private String group;


}
