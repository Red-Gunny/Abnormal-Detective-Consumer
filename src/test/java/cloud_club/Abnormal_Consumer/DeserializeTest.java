package cloud_club.Abnormal_Consumer;

import cloud_club.Abnormal_Consumer.message.Message;
import cloud_club.Abnormal_Consumer.service.DeliverService;
import cloud_club.Abnormal_Consumer.service.DetectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class DeserializeTest {

    @Autowired
    private DetectService detectService;

    @Autowired
    private DeliverService deliverService;

    @Test
    public void 역직렬화_탐지_테스트() throws JsonProcessingException {
        String src = "{\"userId\":\"56c3883b-f69c-43a1-9882-974a963ec1d7\",\"messageId\":\"a6b47ec7-d605-46d0-be41-e2e7f26f3d3a\",\"messageSeq\":0,\"message\":\"하 씨발 인생\"}";
        Message msg = Message.toMessageFromJsonString(src);
        msg = detectService.detectMessage(msg);
        System.out.println(msg.getMessage());
    }

    @Test
    public void 전송_테스트() throws JsonProcessingException {
        String src = "{\"userId\":\"56c3883b-f69c-43a1-9882-974a963ec1d7\",\"messageId\":\"a6b47ec7-d605-46d0-be41-e2e7f26f3d3a\",\"messageSeq\":0,\"message\":\"진짜 존나 이직마렵\"}";
        Message msg = Message.toMessageFromJsonString(src);
        msg = detectService.detectMessage(msg);
        deliverService.sendAbnormalResult(msg);
    }

}
