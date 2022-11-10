package dev.dmgiangi.springrediscaching.entities.repositories;

import dev.dmgiangi.springrediscaching.entities.ScanContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * ScanContextRepository interface.
 *
 * @author Gianluigi De Marco
 */
@Repository
public interface ScanContextRepository extends CrudRepository<ScanContext, UUID> {
}
