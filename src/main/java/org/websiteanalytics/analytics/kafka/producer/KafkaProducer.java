package org.websiteanalytics.analytics.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.websiteanalytics.analytics.utils.AnalyticsLog;

@Component
public class KafkaProducer{
    @Autowired
    private KafkaTemplate<String, AnalyticsLog> kafkaTemplate;

    public void sendMessage(String topic, AnalyticsLog analyticsLog){
//        Integer partition=0;
//        String key=
        kafkaTemplate.send(topic,analyticsLog);
    }
}
