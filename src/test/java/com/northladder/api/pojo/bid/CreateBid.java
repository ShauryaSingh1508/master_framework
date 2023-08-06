
package com.northladder.api.pojo.bid;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateBid {
    private String assetId;
    private Integer spotPrice;
    private Integer maxQuantity;
    private Boolean isBidActive;
    private Boolean isStorageProvider;
    private Boolean autoTopupEnabled;

}
