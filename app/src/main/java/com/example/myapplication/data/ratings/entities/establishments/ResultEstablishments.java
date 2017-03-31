
package com.example.myapplication.data.ratings.entities.establishments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultEstablishments {

    @SerializedName("establishments")
    @Expose
    private List<Establishment> establishments = null;
    @SerializedName("meta")
    @Expose
    private Meta_ meta;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;

    public List<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<Establishment> establishments) {
        this.establishments = establishments;
    }

    public Meta_ getMeta() {
        return meta;
    }

    public void setMeta(Meta_ meta) {
        this.meta = meta;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

}
