package cloud_club.Abnormal_Consumer.service;

import cloud_club.Abnormal_Consumer.message.Message;
import org.springframework.stereotype.Service;

@Service
public class DetectService {

    String[] abnormalWords = new String[] { "씨발", "존나", "개새끼", "병신"};

    public Message detectMessage(Message msg) {
        String convertedMsg = convertMessageIfExist(msg.getMessage());
        return Message.builder()
                .userId(msg.getUserId())
                .messageId(msg.getMessageId())
                .messageSeq(msg.getMessageSeq())
                .message(convertedMsg)
                .build();
    }

    private String convertMessageIfExist(String str) {
        if(str == null) {
            return str;
        }
        for (String word : abnormalWords) {
            if (str.contains(word)) {
                str = str.replaceAll(word, "*".repeat(word.length()));
            }
        }
        return str;
    }

}
