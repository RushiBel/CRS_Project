package com.orendasoftware.crs.domain.data.api_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VillageCollection {

    @SerializedName("village")
    @Expose
    private List<Village> village = null;

    public List<Village> getVillage() {
        return village;
    }

    public void setVillage(List<Village> village) {
        this.village = village;
    }

    public class Village {

        @SerializedName("villageId")
        @Expose
        private Integer villageId;
        @SerializedName("villageName")
        @Expose
        private String villageName;
        @SerializedName("tahsilId")
        @Expose
        private Integer tahsilId;

        public Integer getVillageId() {
            return villageId;
        }

        public void setVillageId(Integer villageId) {
            this.villageId = villageId;
        }

        public String getVillageName() {
            return villageName;
        }

        public void setVillageName(String villageName) {
            this.villageName = villageName;
        }

        public Integer getTahsilId() {
            return tahsilId;
        }

        public void setTahsilId(Integer tahsilId) {
            this.tahsilId = tahsilId;
        }

    }
}
