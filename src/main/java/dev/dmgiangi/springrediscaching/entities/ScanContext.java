package dev.dmgiangi.springrediscaching.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Scan Entity hold the information of a ScanContext
 *
 * @author Gianluigi De Marco
 */
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
    private Set<Scan> scans = new HashSet<>();

    /**
     * add a scan to the scan context
     *
     * @param newScan a {@link dev.dmgiangi.springrediscaching.entities.Scan} object
     */
    public void addScan(Scan newScan) {
        scans.add(newScan);
    }

    /**
     * Get an unmodifiable Set of the scan.
     *
     * @return a {@link java.util.Set} object
     */
    public Set<Scan> getScans() {
        return Collections.unmodifiableSet(scans);
    }
}
