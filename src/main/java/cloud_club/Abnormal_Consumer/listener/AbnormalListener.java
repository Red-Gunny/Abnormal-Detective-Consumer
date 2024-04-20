package cloud_club.Abnormal_Consumer.listener;

import cloud_club.Abnormal_Consumer.message.Message;
import cloud_club.Abnormal_Consumer.service.DeliverService;
import cloud_club.Abnormal_Consumer.service.DetectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbnormalListener {

    private static Logger log = LoggerFactory.getLogger(AbnormalListener.class);
    private List<Message> recordList = new ArrayList<>();

    private final DeliverService deliverService;
    private final DetectService detectService;

    @KafkaListener(topics = "message", groupId = "message-02", containerFactory = "customContainerFactory")
    public void messageListener(ConsumerRecord<String, String> record) throws JsonProcessingException {
        log.info(record.value());
        Message msg = Message.toMessageFromJsonString(record.value());
        msg = detectService.detectMessage(msg);
        deliverService.sendAbnormalResult(msg);
    }

}
