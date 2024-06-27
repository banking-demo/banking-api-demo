package com.matiox.banking_service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionReportDTO {

    private LocalDate date;
    private long transactionCount;
}
