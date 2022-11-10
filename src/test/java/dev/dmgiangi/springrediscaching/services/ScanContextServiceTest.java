package dev.dmgiangi.springrediscaching.services;

import dev.dmgiangi.springrediscaching.entities.ScanContext;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextRto;
import dev.dmgiangi.springrediscaching.entities.mappers.ScanContextMapper;
import dev.dmgiangi.springrediscaching.entities.repositories.ScanContextRepository;
import dev.dmgiangi.springrediscaching.exceptions.EntityDoesNotExist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ScanContextServiceTest {

    private ScanContextService service;

    private ScanContextRepository repository;

    @BeforeEach
    public void eraseKeys() {
        repository = mock(ScanContextRepository.class);
        service = new ScanContextService(repository);
    }

    @Test
    void createFrom() {
        ScanContextRto creationRequest = new ScanContextRto(
                "test text",
                50.05,
                13
        );
        ScanContext scanContext = ScanContextMapper.MAP.fromRto(creationRequest);
        scanContext.setData(LocalDate.now());
        scanContext.setId(UUID.randomUUID());

        when(repository.save(Mockito.any(ScanContext.class))).thenReturn(scanContext);

        ScanContextDto scanContextDto = service.createFrom(creationRequest);

        assertThat(scanContextDto).isNotNull();

        assertThat(scanContextDto.getId()).isNotNull();
        assertThat(scanContextDto.getScans().size()).isEqualTo(0);
        assertThat(scanContextDto.getAnDouble()).isEqualTo(50.05);
        assertThat(scanContextDto.getAnInteger()).isEqualTo(13);
        assertThat(scanContextDto.getText()).isEqualTo("test text");
        assertThat(scanContextDto.getData()).isEqualTo(LocalDate.now());
    }

    @Test
    void getByWrongId() {
        UUID id = UUID.randomUUID();

        when(repository.findById(id))
                .thenReturn(Optional.empty());

        assertThrows(
                EntityDoesNotExist.class,
                () -> service.getById(id)
        );
    }

    @Test
    void deleteByWrong() {
        UUID id = UUID.randomUUID();

        when(repository.existsById(id))
                .thenReturn(false);

        assertThrows(
                EntityDoesNotExist.class,
                () -> service.deleteById(id)
        );
    }
}