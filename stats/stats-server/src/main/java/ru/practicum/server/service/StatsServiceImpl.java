package ru.practicum.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.ViewStatsDto;
import ru.practicum.server.common.GetStatsRequest;
import ru.practicum.server.mapper.StatsMapper;

import ru.practicum.server.repository.EndpointHitRepository;

import java.util.Collection;

import static ru.practicum.server.mapper.StatsMapper.toEndpointHit;

@Service
@AllArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final EndpointHitRepository endpointHitRepository;


    @Override
    public void createEndpointHit(EndpointHitDto endpointHitDto) {
        endpointHitRepository.save(toEndpointHit(endpointHitDto));
    }

    @Override
    public Collection<ViewStatsDto> findViewStat(GetStatsRequest getStatsRequest) {
//        if (getStatsRequest.getUris().isEmpty()) {
//            if (getStatsRequest.getUnique()) {
//
//            } else {
//
//            }
//        } else {
//
//        }
//
//
//        return viewStatsRepository.search();
//    }

//    public Collection<ViewStatsDto> findViewStat(GetStatsRequest getStatsRequest) {
//         endpointHitRepository.findAllStartIsAfterEndIsBefore(
//                 getStatsRequest.getStart(), getStatsRequest.getEnd()).stream()



        return endpointHitRepository.countHitsByIP(getStatsRequest.getStart(), getStatsRequest.getEnd()).stream()
                .map(StatsMapper::toViewStatsDto)
                .toList();

//        return  null;
    }


}
