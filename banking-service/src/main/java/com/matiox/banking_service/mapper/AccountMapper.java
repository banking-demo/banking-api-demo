package com.matiox.banking_service.mapper;

import com.matiox.banking_service.model.dto.AccountRequestDTO;
import com.matiox.banking_service.model.dto.AccountResponseDTO;
import com.matiox.banking_service.model.entity.Account;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor // Generar Constructor
public class AccountMapper {

    private final ModelMapper modelMapper;
    public Account convertToEntity(AccountRequestDTO accountRequestDTO){
        return modelMapper.map(accountRequestDTO, Account.class);
    }
    public AccountResponseDTO convertToDTO(Account account){
        return modelMapper.map(account, AccountResponseDTO.class);
    }

    public List<AccountResponseDTO> convertToDTO(List<Account> accounts){

        //Recorrer la Lista
        return accounts.stream()
                .map(this::convertToDTO)
                .toList();
    }




}
