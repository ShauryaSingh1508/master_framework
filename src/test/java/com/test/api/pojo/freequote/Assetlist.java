
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
public class Assetlist {

    @JsonProperty("status")
        private Boolean status;
    @JsonProperty("message")
        private String message;
    @JsonProperty("data")
        private List<Datum> data;


}
