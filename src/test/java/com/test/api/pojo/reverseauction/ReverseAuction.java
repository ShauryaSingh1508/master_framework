
package com.test.api.pojo.reverseauction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReverseAuction {
    @JsonProperty("freeQuoteId")
    private String freeQuoteId;
    @JsonProperty("storageProviderId")
    private String storageProviderId;
    @JsonProperty("categoryType")
    private String categoryType;
    @JsonProperty("email")
    private String email;
    @JsonProperty("model")
    private String model;
    @JsonProperty("assetSpecifications")
    private List<AssetSpecification> assetSpecifications = null;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("noOfDays")
    private Integer noOfDays;
    @JsonProperty("customerName")
    private String customerName;
    @JsonProperty("phoneNo")
    private String phoneNo;

    @JsonProperty("freeQuoteId")
    public String getFreeQuoteId() {
        return freeQuoteId;
    }

    @JsonProperty("freeQuoteId")
    public ReverseAuction setFreeQuoteId(String freeQuoteId) {
        this.freeQuoteId = freeQuoteId;
        return this;
    }

    @JsonProperty("storageProviderId")
    public String getStorageProviderId() {
        return storageProviderId;
    }

    @JsonProperty("storageProviderId")
    public ReverseAuction setStorageProviderId(String storageProviderId) {
        this.storageProviderId = storageProviderId;
        return this;
    }

    @JsonProperty("categoryType")
    public String getCategoryType() {
        return categoryType;
    }

    @JsonProperty("categoryType")
    public ReverseAuction setCategoryType(String categoryType) {
        this.categoryType = categoryType;
        return this;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public ReverseAuction setEmail(String email) {
        this.email = email;
        return this;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public ReverseAuction setModel(String model) {
        this.model = model;
        return this;
    }

    @JsonProperty("assetSpecifications")
    public List<AssetSpecification> getAssetSpecifications() {
        return assetSpecifications;
    }

    @JsonProperty("assetSpecifications")
    public ReverseAuction setAssetSpecifications(List<AssetSpecification> assetSpecifications) {
        this.assetSpecifications = assetSpecifications;
        return this;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public ReverseAuction setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @JsonProperty("noOfDays")
    public Integer getNoOfDays() {
        return noOfDays;
    }

    @JsonProperty("noOfDays")
    public ReverseAuction setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
        return this;
    }

    @JsonProperty("customerName")
    public String getCustomerName() {
        return customerName;
    }

    @JsonProperty("customerName")
    public ReverseAuction setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    @JsonProperty("phoneNo")
    public String getPhoneNo() {
        return phoneNo;
    }

    @JsonProperty("phoneNo")
    public ReverseAuction setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

}
