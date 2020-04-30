package cloud.push;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class Handler {

    public Mono<ServerResponse> handle(ServerRequest req) {
        final String responseText = String.format("Notification has been sent by push (ID: %s)",
                UUID.randomUUID().toString()
        );

        final Mono<ServerResponse> successResponse = ok()
                .contentType(TEXT_PLAIN)
                .body(Mono.just(responseText), String.class);

        return req.bodyToMono(MessageDto.class)
                .doOnNext(this::notify)
                .then(successResponse);
    }

    private void notify(MessageDto message) {
        String pattern = "Message has been sent by push%n" +
                "Recipient: %s%n" +
                "Text: %s%n" +
                "Time: %s%n";
        String notification = String.format(
                pattern,
                message.getRecipient(),
                message.getText(),
                message.getCreation()
        );
        System.out.println(notification);
    }
}
