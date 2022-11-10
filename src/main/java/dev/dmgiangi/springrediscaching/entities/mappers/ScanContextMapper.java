package dev.dmgiangi.springrediscaching.entities.mappers;

import dev.dmgiangi.springrediscaching.entities.ScanContext;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextRto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ScanContextMapper interface.
 *
 * @author Gianluigi De Marco
 */
@Mapper
public interface ScanContextMapper {
    /**
     * Constant <code>MAP</code> hold the instance of the mapper
     */
    ScanContextMapper MAP = Mappers.getMapper(ScanContextMapper.class);

    /**
     * Map the attributes of a ScanContext over a ScanContextDto
     *
     * @param scanContext a {@link dev.dmgiangi.springrediscaching.entities.ScanContext} object
     * @return a {@link dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto} object
     */
    ScanContextDto toDto(ScanContext scanContext);

    /**
     * Map the attributes of a ScanContextRto over a ScanContext
     *
     * @param rto a {@link dev.dmgiangi.springrediscaching.entities.dtos.ScanContextRto} object
     * @return a {@link dev.dmgiangi.springrediscaching.entities.ScanContext} object
     */
    ScanContext fromRto(ScanContextRto rto);
}
