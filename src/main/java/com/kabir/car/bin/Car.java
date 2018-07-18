
package com.kabir.car.bin;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Car {

    @SerializedName("Car")
    @Expose
    private List<Car_> car = null;

    public List<Car_> getCar() {
        return car;
    }

    public void setCar(List<Car_> car) {
        this.car = car;
    }

}
