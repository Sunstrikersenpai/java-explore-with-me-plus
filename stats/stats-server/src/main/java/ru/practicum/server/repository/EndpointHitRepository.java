package ru.practicum.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.server.model.EndpointHit;
import ru.practicum.server.model.ViewStats;

import java.time.LocalDateTime;
import java.util.List;

public interface EndpointHitRepository extends JpaRepository<EndpointHit,Long> {

    // получаем сущность ViewStats, отличную от сущности репозитория
    @Query ("select new ru.practicum.server.model.ViewStats(e.app, e.uri, count(e.ip)) " +
            "from EndpointHit as e " +
            "where e.uri in ?3 and " +
            "e.timestamp between ?1 and ?2 " +
            "group by e.app, e.uri " +
            "order by count(e.ip) desc")
    List<ViewStats> countHitsByIp(LocalDateTime start, LocalDateTime end, List<String> uris);

    @Query ("select new ru.practicum.server.model.ViewStats(e.app, e.uri, count(distinct(e.ip))) " +
            "from EndpointHit as e " +
            "where e.uri in ?3 and " +
            "e.timestamp between ?1 and ?2 " +
            "group by e.app, e.uri " +
            "order by count(e.ip) desc")
    List<ViewStats> countHitsByUniqueIp(LocalDateTime start, LocalDateTime end, List<String> uris);


}
