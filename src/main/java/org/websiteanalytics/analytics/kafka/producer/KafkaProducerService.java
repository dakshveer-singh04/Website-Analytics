package org.websiteanalytics.analytics.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.websiteanalytics.analytics.utils.AnalyticsLog;

@Service
public class KafkaProducerService {
    @Value("${spring.kafka.topic.name}")
    String TOPIC_NAME;

    @Autowired
    private KafkaProducer kafkaProducer;

    public void sendMessage(AnalyticsLog analyticsLog){
        kafkaProducer.sendMessage(TOPIC_NAME,analyticsLog);
    }
}
