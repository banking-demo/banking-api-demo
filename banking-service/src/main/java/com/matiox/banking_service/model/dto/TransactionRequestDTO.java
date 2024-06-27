package com.matiox.banking_service.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDTO {

    private Long id;
    @NotNull(message = "El número de la cuenta orgien no puede estar vacio")
    private String sourceAccountNumber;

    @NotNull(message = "El npumero de la cuenta destino no puede estar vacio")
    private String targetAccountNumber;

    @NotNull(message = "La cantidad no puede estar vacia")
    @DecimalMin(value = "0.01", message = "La cantuidad debe ser mayor a 0")
    private BigDecimal amount;

    @NotBlank(message = "La descripción no puede estar vacia")
    private String description;

}
