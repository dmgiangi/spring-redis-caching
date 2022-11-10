package dev.dmgiangi.springrediscaching.services;

import dev.dmgiangi.springrediscaching.entities.ScanContext;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextRto;
import dev.dmgiangi.springrediscaching.entities.mappers.ScanContextMapper;
import dev.dmgiangi.springrediscaching.entities.repositories.ScanContextRepository;
import dev.dmgiangi.springrediscaching.exceptions.EntityDoesNotExist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

/**
 * ScanContextService class.
 *
 * @author Gianluigi De Marco
 */
@Service
@AllArgsConstructor
public class ScanContextService {
    private ScanContextRepository scanContextRepository;

    /**
     * Create and persist a Scan Context from a ScanContextRto.
     *
     * @param request a {@link dev.dmgiangi.springrediscaching.entities.dtos.ScanContextRto} object
     * @return a {@link dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto} object
     */
    public ScanContextDto createFrom(ScanContextRto request) {
        ScanContext scanContext = ScanContextMapper.MAP.fromRto(request);
        scanContext.setData(LocalDate.now());
        scanContext.setId(UUID.randomUUID());

        scanContext = scanContextRepository.save(scanContext);

        return ScanContextMapper.MAP.toDto(scanContext);
    }

    /**
     * Get a persisted ScanContext searching by id.
     *
     * @param id a {@link java.util.UUID} object
     * @return a {@link dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto} object
     * @throws dev.dmgiangi.springrediscaching.exceptions.EntityDoesNotExist if the
     *                                                                       resource is not found
     */
    public ScanContextDto getById(UUID id) {
        ScanContext scanContext = scanContextRepository
                .findById(id)
                .orElseThrow(() -> new EntityDoesNotExist("this scan context does not exist"));

        return ScanContextMapper.MAP.toDto(scanContext);
    }

    /**
     * Delete a persisted ScanContext searching by id.
     *
     * @param id a {@link java.util.UUID} object
     * @throws dev.dmgiangi.springrediscaching.exceptions.EntityDoesNotExist if the
     *                                                                       resource is not found
     */
    public void deleteById(UUID id) {
        if (scanContextRepository.existsById(id))
            scanContextRepository.deleteById(id);
        else
            throw new EntityDoesNotExist("this scan context does not exist");
    }
}
