package com.matiox.banking_service.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDTO {
    //Validaciones
    @NotBlank(message = "El número de cuenta no puede estar vacio")
    @Size(min = 5, max = 20, message = "El número de cuenta debe tener entre 5 y 20 caracteres")
    @Pattern(regexp = "[0-9]+", message = "El número de cuenta debe contener solo digitos")
    private String accountNumber;
    @NotNull(message = "El saldo no puede ser vacio")
    private BigDecimal balance;
    @NotBlank(message = "El nombre del titular no puede estar vacio")
    private String ownerName;
    //Validar Email
    @NotBlank(message = "El correo electrónico no puede estar vacio")
    @Email()
    private String ownerEmail;



}
