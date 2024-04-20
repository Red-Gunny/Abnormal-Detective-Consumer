package cloud_club.Abnormal_Consumer.service;

import cloud_club.Abnormal_Consumer.message.Message;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DeliverService {

    private final WebClient webClient;

    public DeliverService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    public void sendAbnormalResult(Message msg) {
        webClient.post()
                .uri("/rcv")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(msg))
                .retrieve()
                .bodyToMono(Message.class)
                .subscribe(
                        response -> System.out.println("Response received: " + response),
                        error -> System.err.println("Error occurred: " + error.getMessage())
                );
    }

}
