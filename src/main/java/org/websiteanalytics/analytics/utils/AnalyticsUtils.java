package org.websiteanalytics.analytics.utils;

public class AnalyticsUtils {
    public static AnalyticsLog getLogFromDto(AnalyticsLogDTO analyticsLogDTO){
        return new AnalyticsLog("log_id:"+System.currentTimeMillis(),analyticsLogDTO.getLog());
    }
}
