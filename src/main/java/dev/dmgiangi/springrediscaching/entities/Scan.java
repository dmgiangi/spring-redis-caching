package dev.dmgiangi.springrediscaching.entities;

import lombok.*;

import java.util.UUID;


/**
 * Scan Entity hold the information os a single scan
 *
 * @author Gianluigi De Marco
 */
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

