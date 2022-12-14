package dev.dmgiangi.springrediscaching.exceptions.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Dto to serialize a generic multiple cause error
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 10 09 2022
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class MultipleErrorDto {

    private final LocalDateTime timestamp = LocalDateTime.now();

    @Schema(example = "400 BAD REQUEST")
    private HttpStatus status;

    @Schema(example = "There are error in some field")
    private String error;

    @Schema(ref = "mapErrorDto")
    private Map<String, List<String>> errorMessages;

    @Schema(example = "/scan-context/d4b1d5d3-4823-42f9-abc3-3a37361af3ca")
    private String path;
}
