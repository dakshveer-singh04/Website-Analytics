package org.websiteanalytics.analytics.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.websiteanalytics.analytics.utils.AnalyticsLog;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "group0", topicPartitions = {
            @TopicPartition(topic = "${spring.kafka.topic.name}", partitions = { "0" }) })
    public void listenGroup1(
            @Payload AnalyticsLog message,
//            @Header(KafkaHeaders.PARTITION) int partitionId,
            @Header(KafkaHeaders.OFFSET) int offset,
            @Header(KafkaHeaders.GROUP_ID) String groupId
    ) {
        String logLine =message.getLog();
        String logId=message.getLog_id();

        System.out.println(
                "[KAFKA] - Received :: Log_id="+logId+", logLine="+logLine
        );
    }

}
