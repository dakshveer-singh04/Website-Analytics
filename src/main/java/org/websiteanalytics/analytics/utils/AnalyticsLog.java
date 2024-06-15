package org.websiteanalytics.analytics.utils;

public class AnalyticsLog {
    String log_id;
    String log;

    public AnalyticsLog() {
    }

    public AnalyticsLog(String log_id, String log) {
        this.log_id = log_id;
        this.log = log;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }
}
