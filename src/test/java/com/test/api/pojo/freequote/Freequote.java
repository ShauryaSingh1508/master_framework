
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
public class Freequote {

    @JsonProperty("brandName")
    private String brandName;
    @JsonProperty("brandId")
    private String brandId;
    @JsonProperty("categoryId")
    private String categoryId;
    @JsonProperty("isSellAsset")
    private Boolean isSellAsset;
    @JsonProperty("responseToken")
    private String responseToken;
    @JsonProperty("buyBackTimeStamp")
    private String buyBackTimeStamp;
    @JsonProperty("categoryName")
    private String categoryName;
    @JsonProperty("categoryType")
    private String categoryType;
    @JsonProperty("assetId")
    private String assetId;
    @JsonProperty("assetName")
    private String assetName;
    @JsonProperty("condition")
    private Condition condition;
    @JsonProperty("email")
    private String email;

}
