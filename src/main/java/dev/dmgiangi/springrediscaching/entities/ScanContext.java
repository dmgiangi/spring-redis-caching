package dev.dmgiangi.springrediscaching.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RedisHash(value = "scan-context")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@ToString
public class ScanContext {
    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    private String text;

    private LocalDate data;

    private Double anDouble;

    private Integer anInteger;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private final Set<Scan> scans = new HashSet<>();

    public void addScan(Scan newScan) {
        scans.add(newScan);
    }

    public Set<Scan> getScans() {
        return Collections.unmodifiableSet(scans);
    }
}
