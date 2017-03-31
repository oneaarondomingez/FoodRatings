
package com.example.myapplication.data.ratings.entities.establishments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scores {

    @SerializedName("Hygiene")
    @Expose
    private Integer hygiene;
    @SerializedName("Structural")
    @Expose
    private Integer structural;
    @SerializedName("ConfidenceInManagement")
    @Expose
    private Integer confidenceInManagement;

    public Integer getHygiene() {
        return hygiene;
    }

    public void setHygiene(Integer hygiene) {
        this.hygiene = hygiene;
    }

    public Integer getStructural() {
        return structural;
    }

    public void setStructural(Integer structural) {
        this.structural = structural;
    }

    public Integer getConfidenceInManagement() {
        return confidenceInManagement;
    }

    public void setConfidenceInManagement(Integer confidenceInManagement) {
        this.confidenceInManagement = confidenceInManagement;
    }

}
