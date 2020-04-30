package cloud.sms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {

    private String recipient;

    private String text;

    @JsonIgnore
    private final LocalDateTime creation;

    public MessageDto(String recipient, String text) {
        this.recipient = recipient;
        this.text = text;
        this.creation = LocalDateTime.now();
    }

    public MessageDto() {
        this.creation = LocalDateTime.now();
    }
}
