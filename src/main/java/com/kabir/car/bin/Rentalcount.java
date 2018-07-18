
package com.kabir.car.bin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rentalcount {

    @SerializedName("lastweek")
    @Expose
    private Integer lastweek;
    @SerializedName("yeartodate")
    @Expose
    private Integer yeartodate;

    public Integer getLastweek() {
        return lastweek;
    }

    public void setLastweek(Integer lastweek) {
        this.lastweek = lastweek;
    }

    public Integer getYeartodate() {
        return yeartodate;
    }

    public void setYeartodate(Integer yeartodate) {
        this.yeartodate = yeartodate;
    }

}
