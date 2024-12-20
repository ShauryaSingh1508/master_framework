
package com.test.api.pojo.reverseauction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetSpecification {

    @JsonProperty("key")
    private String key;
    @JsonProperty("value")
    private String value;

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public AssetSpecification setKey(String key) {
        this.key = key;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public AssetSpecification setValue(String value) {
        this.value = value;
        return this;
    }

}
