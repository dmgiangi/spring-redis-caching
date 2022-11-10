package dev.dmgiangi.springrediscaching.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

/**
 * ScanContextRto class.
 *
 * @author Gianluigi De Marco
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScanContextRto {
    @NotEmpty
    private String text;

    @DecimalMax("10.0")
    @DecimalMin("0.0")
    private double anDouble;

    private int anInteger;
}
