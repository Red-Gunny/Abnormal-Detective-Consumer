package cloud_club.Abnormal_Consumer;

import cloud_club.Abnormal_Consumer.listener.AbnormalListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.util.List;

@SpringBootTest
@EmbeddedKafka(partitions = 3,
                brokerProperties = { "listeners=PLAINTEXT://localhost:9092"},
                ports = {9092})
public class ConsumerSettingTest {

//    @Autowired
//    KafkaProducer producer;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @Autowired
//    private AbnormalListener listener;
//
//    @Test
//    void test() throws Exception {
//        producer.send("message", "mm");
//        List<String> recList = listener.getRecordList();
//        recList.stream().forEach(System.out::println);
//    }
}
