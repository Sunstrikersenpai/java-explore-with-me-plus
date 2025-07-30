package ru.practicum.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.server.model.EndpointHit;
import ru.practicum.server.model.ViewStats;

import java.time.LocalDateTime;
import java.util.List;

public interface EndpointHitRepository extends JpaRepository<EndpointHit,Long> {

//    @Query ("select new ViewStats(s.app, s.uri, count(s.ip)) from EndpointHit as s " +
//            "where s.hittime between ?1 and ?2 group by s.app, s.uri order by count(s.ip) desc")
//    List<ViewStats> countHitsByIP(LocalDateTime start, LocalDateTime end);


    @Query (value = "select s.app, s.uri, count(s.ip) from stats as s " +
            "where s.hittime between ?1 and ?2 group by s.app, s.uri order by count(s.ip) desc", nativeQuery = true)
    List<ViewStats> countHitsByIP(LocalDateTime start, LocalDateTime end);

//    @Query("select new ViewStats(e.app, e.uri, count(e.ip)) from EndpointHit as e")
//    List<ViewStats> findAllStartIsAfterEndIsBefore(LocalDateTime start, LocalDateTime end);


    // SELECT app, uri, COUNT(ip)
    //FROM stats WHERE
    //uri IN ('/events/1', '/events/3' )
    //AND
    //hittime BETWEEN '2022-09-06 10:00:23' AND '2022-09-06 13:00:23'
    //GROUP BY app, uri
    //ORDER BY COUNT(ip) DESC
}
