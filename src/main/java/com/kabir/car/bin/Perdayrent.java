
package com.kabir.car.bin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Perdayrent {

    @SerializedName("Price")
    @Expose
    private Integer price;
    @SerializedName("Discount")
    @Expose
    private Integer discount;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}
