package com.orendasoftware.crs.domain.data.api_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TahasilCollection {

    @SerializedName("tehsil")
    @Expose
    private List<Tehsil> tehsil = null;

    public List<Tehsil> getTehsil() {
        return tehsil;
    }

    public void setTehsil(List<Tehsil> tehsil) {
        this.tehsil = tehsil;
    }

    public class Tehsil {

        @SerializedName("tahsilId")
        @Expose
        private Integer tahsilId;
        @SerializedName("tahsilName")
        @Expose
        private String tahsilName;
        @SerializedName("districtId")
        @Expose
        private Integer districtId;

        public Integer getTahsilId() {
            return tahsilId;
        }

        public void setTahsilId(Integer tahsilId) {
            this.tahsilId = tahsilId;
        }

        public String getTahsilName() {
            return tahsilName;
        }

        public void setTahsilName(String tahsilName) {
            this.tahsilName = tahsilName;
        }

        public Integer getDistrictId() {
            return districtId;
        }

        public void setDistrictId(Integer districtId) {
            this.districtId = districtId;
        }

    }
}
