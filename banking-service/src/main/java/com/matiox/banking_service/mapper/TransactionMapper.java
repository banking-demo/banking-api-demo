package com.matiox.banking_service.mapper;

import com.matiox.banking_service.model.dto.TransactionReportDTO;
import com.matiox.banking_service.model.dto.TransactionRequestDTO;
import com.matiox.banking_service.model.dto.TransactionResponseDTO;
import com.matiox.banking_service.model.entity.Transaction;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class TransactionMapper {

    private final ModelMapper modelMapper;

    private Transaction convertToEntity(TransactionRequestDTO transactionRequestDTO){
        return modelMapper.map(transactionRequestDTO, Transaction.class);

    }

    private TransactionResponseDTO convertoDTO(Transaction transaction){

        return modelMapper.map(transaction, TransactionResponseDTO.class);

    }

    private List<TransactionResponseDTO> converToDTO(List<Transaction> transactions){

        return transactions.stream()
                .map(this::convertoDTO)
                .toList();
    }

    public TransactionReportDTO convertTransactionReportDTO(Object [] transactionsData){
        TransactionReportDTO reportDTO = new TransactionReportDTO();
        reportDTO.setDate((LocalDate) transactionsData[0]);
        reportDTO.setTransactionCount((Long) transactionsData[1]);
        return reportDTO;

    }
}
