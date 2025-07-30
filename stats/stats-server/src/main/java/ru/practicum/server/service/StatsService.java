package ru.practicum.server.service;

import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.ViewStatsDto;
import ru.practicum.server.common.GetStatsRequest;
import ru.practicum.server.model.ViewStats;

import java.util.Collection;

public interface StatsService {

    void createEndpointHit(EndpointHitDto endpointHitDto);

    Collection<ViewStatsDto> findViewStat(GetStatsRequest getStatsRequest);
}
