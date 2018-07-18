
package com.kabir.car.bin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Car_ {

    @SerializedName("make")
    @Expose
    private String make;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("vin")
    @Expose
    private String vin;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("perdayrent")
    @Expose
    private Perdayrent perdayrent;
    @SerializedName("metrics")
    @Expose
    private Metrics metrics;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Perdayrent getPerdayrent() {
        return perdayrent;
    }

    public void setPerdayrent(Perdayrent perdayrent) {
        this.perdayrent = perdayrent;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

}
