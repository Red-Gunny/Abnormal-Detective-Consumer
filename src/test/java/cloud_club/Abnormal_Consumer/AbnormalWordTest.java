package cloud_club.Abnormal_Consumer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AbnormalWordTest {

    String[] abnormalWords = new String[] { "씨발", "존나", "개새끼", "병신"};

    @Test
    public void 단어탐지_스트림_작동_테스트() {
        String src1 = "나는행복 근데 존메";

        String[] abnormalWords = new String[] { "씨발", "존나", "개새끼", "병신"};

        System.out.println(Arrays.stream(abnormalWords).anyMatch(src1::contains));
    }

    @Test
    public void 메소드_통합_테스트() {
        String targetStr = "아이고 씨발";
        for (String word : abnormalWords) {
            if (targetStr.contains(word)) {
                targetStr = targetStr.replaceAll(word, "*".repeat(word.length()));
            }
        }
        System.out.println(targetStr);
    }


}
