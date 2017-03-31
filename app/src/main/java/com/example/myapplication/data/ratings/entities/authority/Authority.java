
package com.example.myapplication.data.ratings.entities.authority;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Authority {

    @SerializedName("LocalAuthorityId")
    @Expose
    private Integer localAuthorityId;
    @SerializedName("LocalAuthorityIdCode")
    @Expose
    private String localAuthorityIdCode;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("EstablishmentCount")
    @Expose
    private Integer establishmentCount;
    @SerializedName("SchemeType")
    @Expose
    private Integer schemeType;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;

    public Integer getLocalAuthorityId() {
        return localAuthorityId;
    }

    public void setLocalAuthorityId(Integer localAuthorityId) {
        this.localAuthorityId = localAuthorityId;
    }

    public String getLocalAuthorityIdCode() {
        return localAuthorityIdCode;
    }

    public void setLocalAuthorityIdCode(String localAuthorityIdCode) {
        this.localAuthorityIdCode = localAuthorityIdCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstablishmentCount() {
        return establishmentCount;
    }

    public void setEstablishmentCount(Integer establishmentCount) {
        this.establishmentCount = establishmentCount;
    }

    public Integer getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(Integer schemeType) {
        this.schemeType = schemeType;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
