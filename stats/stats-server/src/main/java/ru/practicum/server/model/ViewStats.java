package ru.practicum.server.model;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "stats")
@Getter
@Setter
@ToString
@AllArgsConstructor

public class ViewStats {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "app", nullable = false)
    private String app;
//    @Column(name = "uri", nullable = false)
    private String uri;
//    @Column(name = "count_hits", nullable = false)
    private Long hits;

}
