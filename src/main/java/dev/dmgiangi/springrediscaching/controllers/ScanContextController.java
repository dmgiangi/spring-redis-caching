package dev.dmgiangi.springrediscaching.controllers;

import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextRto;
import dev.dmgiangi.springrediscaching.services.ScanContextService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("scan-context")
@AllArgsConstructor
public class ScanContextController {
    ScanContextService scanContextService;

    @PostMapping
    public ResponseEntity<ScanContextDto> createScanContext(@RequestBody @Valid ScanContextRto request) {
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

    @GetMapping("{id}")
    public ScanContextDto getScanContext(@PathVariable UUID id){
        return scanContextService.getById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteScanContext(@PathVariable UUID id){
        scanContextService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
