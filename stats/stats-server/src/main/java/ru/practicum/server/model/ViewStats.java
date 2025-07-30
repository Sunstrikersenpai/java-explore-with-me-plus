package ru.practicum.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "stats")
@Getter
@Setter
@ToString
public class ViewStats {

    private String app;
    private String uri;
    private Long hits;

}
