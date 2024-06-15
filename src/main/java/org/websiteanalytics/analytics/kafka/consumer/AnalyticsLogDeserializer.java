package org.websiteanalytics.analytics.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.websiteanalytics.analytics.utils.AnalyticsLog;

import java.io.IOException;
import java.util.Map;

public class AnalyticsLogDeserializer implements Deserializer<AnalyticsLog> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public AnalyticsLog deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, AnalyticsLog.class);
        } catch (IOException eX) {
            eX.printStackTrace();
            return null;
        }
    }
}

