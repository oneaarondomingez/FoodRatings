
package com.example.myapplication.data.ratings.entities.establishments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Establishment {

    @SerializedName("FHRSID")
    @Expose
    private Integer fHRSID;
    @SerializedName("LocalAuthorityBusinessID")
    @Expose
    private String localAuthorityBusinessID;
    @SerializedName("BusinessName")
    @Expose
    private String businessName;
    @SerializedName("BusinessType")
    @Expose
    private String businessType;
    @SerializedName("BusinessTypeID")
    @Expose
    private Integer businessTypeID;
    @SerializedName("AddressLine1")
    @Expose
    private String addressLine1;
    @SerializedName("AddressLine2")
    @Expose
    private String addressLine2;
    @SerializedName("AddressLine3")
    @Expose
    private String addressLine3;
    @SerializedName("AddressLine4")
    @Expose
    private String addressLine4;
    @SerializedName("PostCode")
    @Expose
    private String postCode;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("RatingValue")
    @Expose
    private String ratingValue;
    @SerializedName("RatingKey")
    @Expose
    private String ratingKey;
    @SerializedName("RatingDate")
    @Expose
    private String ratingDate;
    @SerializedName("LocalAuthorityCode")
    @Expose
    private String localAuthorityCode;
    @SerializedName("LocalAuthorityName")
    @Expose
    private String localAuthorityName;
    @SerializedName("LocalAuthorityWebSite")
    @Expose
    private String localAuthorityWebSite;
    @SerializedName("LocalAuthorityEmailAddress")
    @Expose
    private String localAuthorityEmailAddress;
    @SerializedName("scores")
    @Expose
    private Scores scores;
    @SerializedName("SchemeType")
    @Expose
    private String schemeType;
    @SerializedName("geocode")
    @Expose
    private Geocode geocode;
    @SerializedName("RightToReply")
    @Expose
    private String rightToReply;
    @SerializedName("Distance")
    @Expose
    private Object distance;
    @SerializedName("NewRatingPending")
    @Expose
    private Boolean newRatingPending;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;

    public Integer getFHRSID() {
        return fHRSID;
    }

    public void setFHRSID(Integer fHRSID) {
        this.fHRSID = fHRSID;
    }

    public String getLocalAuthorityBusinessID() {
        return localAuthorityBusinessID;
    }

    public void setLocalAuthorityBusinessID(String localAuthorityBusinessID) {
        this.localAuthorityBusinessID = localAuthorityBusinessID;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getBusinessTypeID() {
        return businessTypeID;
    }

    public void setBusinessTypeID(Integer businessTypeID) {
        this.businessTypeID = businessTypeID;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getRatingKey() {
        return ratingKey;
    }

    public void setRatingKey(String ratingKey) {
        this.ratingKey = ratingKey;
    }

    public String getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(String ratingDate) {
        this.ratingDate = ratingDate;
    }

    public String getLocalAuthorityCode() {
        return localAuthorityCode;
    }

    public void setLocalAuthorityCode(String localAuthorityCode) {
        this.localAuthorityCode = localAuthorityCode;
    }

    public String getLocalAuthorityName() {
        return localAuthorityName;
    }

    public void setLocalAuthorityName(String localAuthorityName) {
        this.localAuthorityName = localAuthorityName;
    }

    public String getLocalAuthorityWebSite() {
        return localAuthorityWebSite;
    }

    public void setLocalAuthorityWebSite(String localAuthorityWebSite) {
        this.localAuthorityWebSite = localAuthorityWebSite;
    }

    public String getLocalAuthorityEmailAddress() {
        return localAuthorityEmailAddress;
    }

    public void setLocalAuthorityEmailAddress(String localAuthorityEmailAddress) {
        this.localAuthorityEmailAddress = localAuthorityEmailAddress;
    }

    public Scores getScores() {
        return scores;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }

    public Geocode getGeocode() {
        return geocode;
    }

    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }

    public String getRightToReply() {
        return rightToReply;
    }

    public void setRightToReply(String rightToReply) {
        this.rightToReply = rightToReply;
    }

    public Object getDistance() {
        return distance;
    }

    public void setDistance(Object distance) {
        this.distance = distance;
    }

    public Boolean getNewRatingPending() {
        return newRatingPending;
    }

    public void setNewRatingPending(Boolean newRatingPending) {
        this.newRatingPending = newRatingPending;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

}
