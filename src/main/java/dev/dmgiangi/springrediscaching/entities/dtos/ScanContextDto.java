package dev.dmgiangi.springrediscaching.entities.dtos;

import dev.dmgiangi.springrediscaching.entities.Scan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

/**
 * ScanContextDto class.
 *
 * @author Gianluigi De Marco
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ScanContextDto {
    private UUID id;

    private String text;

    private LocalDate data;

    private double anDouble;

    private int anInteger;

    private Set<Scan> scans;
}
