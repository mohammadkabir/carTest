
package com.kabir.car.bin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metrics {

    @SerializedName("yoymaintenancecost")
    @Expose
    private Double yoymaintenancecost;
    @SerializedName("depreciation")
    @Expose
    private Double depreciation;
    @SerializedName("rentalcount")
    @Expose
    private Rentalcount rentalcount;

    public Double getYoymaintenancecost() {
        return yoymaintenancecost;
    }

    public void setYoymaintenancecost(Double yoymaintenancecost) {
        this.yoymaintenancecost = yoymaintenancecost;
    }

    public Double getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(Double depreciation) {
        this.depreciation = depreciation;
    }

    public Rentalcount getRentalcount() {
        return rentalcount;
    }

    public void setRentalcount(Rentalcount rentalcount) {
        this.rentalcount = rentalcount;
    }

}
