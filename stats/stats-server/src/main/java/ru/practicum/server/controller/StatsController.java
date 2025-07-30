package ru.practicum.server.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.server.model.ViewStats;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/stats")
public class StatsController {

    @GetMapping
    public Collection<ViewStats> getAll() {
        return  null;
    }
}
