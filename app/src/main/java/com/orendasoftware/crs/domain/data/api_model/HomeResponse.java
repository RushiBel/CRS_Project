package com.orendasoftware.crs.domain.data.api_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeResponse {

    @SerializedName("todaysSurveyCount")
    @Expose
    private Integer todaysSurveyCount;
    @SerializedName("todaysRelocationCount")
    @Expose
    private Integer todaysRelocationCount;
    @SerializedName("todaysQuarantinedCount")
    @Expose
    private Integer todaysQuarantinedCount;
    @SerializedName("totalSurveyCount")
    @Expose
    private Integer totalSurveyCount;
    @SerializedName("totalRelocationCount")
    @Expose
    private Integer totalRelocationCount;
    @SerializedName("totalQuarantinedCount")
    @Expose
    private Integer totalQuarantinedCount;

    public Integer getTodaysSurveyCount() {
        return todaysSurveyCount;
    }

    public Integer getTodaysRelocationCount() {
        return todaysRelocationCount;
    }

    public Integer getTodaysQuarantinedCount() {
        return todaysQuarantinedCount;
    }

    public Integer getTotalSurveyCount() {
        return totalSurveyCount;
    }

    public Integer getTotalRelocationCount() {
        return totalRelocationCount;
    }

    public Integer getTotalQuarantinedCount() {
        return totalQuarantinedCount;
    }
}
