package dev.dmgiangi.springrediscaching.entities;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Scan {
    @EqualsAndHashCode.Include
    private UUID id;

    private String text;
}

