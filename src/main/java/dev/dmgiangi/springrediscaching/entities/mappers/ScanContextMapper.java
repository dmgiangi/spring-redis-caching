package dev.dmgiangi.springrediscaching.entities.mappers;

import dev.dmgiangi.springrediscaching.entities.ScanContext;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextRto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScanContextMapper {
    ScanContextMapper MAP = Mappers.getMapper(ScanContextMapper.class);

    ScanContextDto toDto(ScanContext scanContext);

    ScanContext fromRto(ScanContextRto rto);
}
