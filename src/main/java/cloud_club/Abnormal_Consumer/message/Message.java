package cloud_club.Abnormal_Consumer.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class Message {
    private final String userId;
    private final String messageId;
    private final Long messageSeq;
    private final String message;

    static public Message toMessageFromJsonString(String jsonString) {
        JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
        String userId = jsonObject.get("userId").getAsString();
        String messageId = jsonObject.get("messageId").getAsString();
        Long messageSeq = jsonObject.get("messageSeq").getAsLong();
        String message = jsonObject.get("message").getAsString();
        return Message.builder()
                .userId(userId)
                .messageId(messageId)
                .messageSeq(messageSeq)
                .message(message)
                .build();
    }

}

