package client;

import org.springframework.web.client.RestClient;
import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.ViewStatsDto;

import java.util.List;

public class StatsClient {
    private final RestClient restClient;

    public StatsClient(String baseUrl) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    }

    /**
     * Сохраняет информацию о запросе к эндпоинту (POST /hit)
     */
    public void saveHit(EndpointHitDto hit) {
        restClient.post()
                .uri("/hit")
                .body(hit)
                .retrieve()
                .toBodilessEntity();
    }


    /**
     * Получает статистику по посещениям (GET /stats)
     */
    public List<ViewStatsDto> getStats(String start, String end, List<String> uris, Boolean unique) {
        ViewStatsDto[] statsArray = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/stats")
                        .queryParam("start", start)
                        .queryParam("end", end)
                        .queryParam("uris", uris)
                        .queryParam("unique", unique)
                        .build())
                .retrieve()
                .body(ViewStatsDto[].class);

        return statsArray != null ? List.of(statsArray) : List.of();
    }
}