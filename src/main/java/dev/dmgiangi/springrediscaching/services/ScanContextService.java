package dev.dmgiangi.springrediscaching.services;

import dev.dmgiangi.springrediscaching.entities.Scan;
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

@Service
@AllArgsConstructor
public class ScanContextService {
    private ScanContextRepository scanContextRepository;

    public ScanContextDto createFrom(ScanContextRto request) {
        ScanContext scanContext = ScanContextMapper.MAP.fromRto(request);
        scanContext.setData(LocalDate.now());
        scanContext.setId(UUID.randomUUID());

        scanContext.addScan(new Scan(UUID.randomUUID(), "first scan"));
        scanContext.addScan(new Scan(UUID.randomUUID(), "second scan"));

        scanContextRepository.save(scanContext);

        return ScanContextMapper.MAP.toDto(scanContext);
    }

    public ScanContextDto getById(UUID id) {
        ScanContext scanContext = scanContextRepository
                .findById(id)
                .orElseThrow(() -> new EntityDoesNotExist("this scan context does not exist"));

        return ScanContextMapper.MAP.toDto(scanContext);
    }

    public void deleteById(UUID id) {
        if(scanContextRepository.existsById(id))
            scanContextRepository.deleteById(id);
        else
            throw new EntityDoesNotExist("this scan context does not exist");
    }
}
