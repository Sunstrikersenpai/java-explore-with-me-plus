package ru.practicum.server.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class ViewStats {

    private String app;
    private String uri;
    private Long hits;
}
