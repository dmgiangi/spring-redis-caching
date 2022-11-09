package dev.dmgiangi.springrediscaching.controllers;

import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextRto;
import dev.dmgiangi.springrediscaching.services.ScanContextService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("scan-context")
@AllArgsConstructor
public class ScanContextController {
    ScanContextService scanContextService;

    @PostMapping
    public ResponseEntity<ScanContextDto> scanContext(@RequestBody @Valid ScanContextRto request) {
        ScanContextDto createdScanContext = scanContextService.createFrom(request);

        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentContextPath()
                                .path("scan-context/" + createdScanContext.getId().toString())
                                .build()
                                .toUri()
                )
                .body(createdScanContext);
    }
}
