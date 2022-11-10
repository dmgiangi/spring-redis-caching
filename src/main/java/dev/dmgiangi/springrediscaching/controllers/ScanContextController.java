package dev.dmgiangi.springrediscaching.controllers;

import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto;
import dev.dmgiangi.springrediscaching.entities.dtos.ScanContextRto;
import dev.dmgiangi.springrediscaching.exceptions.model.ErrorDto;
import dev.dmgiangi.springrediscaching.exceptions.model.MultipleErrorDto;
import dev.dmgiangi.springrediscaching.services.ScanContextService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

/**
 * ScanContextController class.
 *
 * @author Gianluigi De Marco
 */
@RestController
@RequestMapping("scan-context")
@AllArgsConstructor
public class ScanContextController {
    ScanContextService scanContextService;

    /**
     * Create a new Scan Context
     *
     * @param request a {@link dev.dmgiangi.springrediscaching.entities.dtos.ScanContextRto} object
     * @return a {@link org.springframework.http.ResponseEntity} object
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Create a new Scan Context",
            description = "Create a new Scan Context",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "new Scan Context created",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ScanContextDto.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Payload are not formerly valid",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = MultipleErrorDto.class)))
            })
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

    /**
     * Get information about a Scan Context searching by id
     *
     * @param id a {@link java.util.UUID} object
     * @return a {@link dev.dmgiangi.springrediscaching.entities.dtos.ScanContextDto} object
     */
    @GetMapping("{id}")
    @Operation(
            summary = "get a Scan Context",
            description = "get information about a Scan Context searching by id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Return Scan Context information",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ScanContextDto.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Scan Context does not exists",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDto.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Parameters are not formerly valid",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDto.class)))
            })
    public ScanContextDto getScanContext(@PathVariable UUID id){
        return scanContextService.getById(id);
    }

    /**
     * Delete information about a Scan Context searching by id
     *
     * @param id a {@link java.util.UUID} object
     * @return a {@link org.springframework.http.ResponseEntity} object
     */
    @DeleteMapping("{id}")
    @Operation(
            summary = "Delete a Scan Context",
            description = "Delete information about a Scan Context searching by id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Return Scan Context information",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ScanContextDto.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Scan Context does not exists",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDto.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Parameters are not formerly valid",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDto.class)))
            })
    public ResponseEntity<Void> deleteScanContext(@PathVariable UUID id){
        scanContextService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
