package ru.practicum.server.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.server.exception.ValidationException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

// для декодирования значений времени и даты
//import java.net.URLDecoder;
//import java.nio.charset.StandardCharsets;

@Data
@NoArgsConstructor
public class GetStatsRequest {
    private LocalDateTime start;
    private LocalDateTime end;
    private List<String> uris;
    private Boolean unique;

    public static GetStatsRequest of(String start,
                                     String end,
                                     List<String> uris,
                                     String unique) {
        GetStatsRequest getStatsRequest = new GetStatsRequest();

// для декодирования значений времени и даты
        // `import java.net.URLEncoder;
        // URLEncoder.encode(start, "UTF-8");
        // URLEncoder.encode(end, "UTF-8");
        // String decodedStart = URLDecoder.decode(start, StandardCharsets.UTF_8);
        // String decodedEnd = URLDecoder.decode(end, StandardCharsets.UTF_8);;

        try {
            getStatsRequest.setStart(LocalDateTime.parse(start,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (DateTimeParseException e) {
            throw new ValidationException(
                    String.format("Ошибка в параметре дата и время начала диапазона - start = %s", start));
        }

        try {
            getStatsRequest.setEnd(LocalDateTime.parse(end,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (DateTimeParseException e) {
            throw new ValidationException(
                    String.format("Ошибка в параметре дата и время конца диапазона - end = %s", end));
        }

        if (getStatsRequest.getStart().isAfter(getStatsRequest.getEnd()))
            throw new ValidationException(
                    String.format("Дата начала диапазона %s после даты конца %s", start, end));

        try {
            getStatsRequest.setUnique(Boolean.valueOf(unique));
        } catch (IllegalArgumentException e) {
            throw new ValidationException(
                    String.format("Ошибка в параметре запроса только уникальных IP - unique = %s", unique));
        }

        if (Objects.isNull(uris)) uris = List.of();
        getStatsRequest.setUris(uris);

        return getStatsRequest;
    }
}
